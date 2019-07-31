package com.test.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.test.Kv;
import com.test.tag.BaseTagSupport;
import com.test.tag.ChooseTag;
import com.test.tag.ForEachTag;
import com.test.tag.IfTag;
import com.test.tag.OutTag;
import com.test.tools.ReflectUtils;
import com.test.tools.StringUtils;

/**
 * @author Administrator
 *
 */
public class PageRendering {

	private static Map<String, Object> context = new HashMap<String, Object>();
	static {
		List<Object> kvList = Arrays.asList(new Kv("01", "值1"), new Kv("02", "值2"),
				new Kv("03", "值3"), new Kv("04", "值4"), new Kv("05", "值5"),
				new Kv("06", "值61"));
		context.put("kvList", kvList);
		context.put("kv", new Kv(5, "05", "值5"));
		context.put("salary", "10000");
		context.put("num", 1000);
		context.put("name", "张安");
	}

	public static void render(String cxtPath) {
		try {
			InputStream is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(cxtPath);
			// 建立一个输入流对象reader
			InputStreamReader reader = new InputStreamReader(is);
			// 建立一个对象，它把文件内容转成计算机能读懂的语言
			BufferedReader br = new BufferedReader(reader);
			StringBuilder sbf = new StringBuilder();
			String tempStr;
			while ((tempStr = br.readLine()) != null) {
				sbf.append(tempStr);
			}
			br.close();
			reader.close();
			String html = sbf.toString();
			String handleHtml = handleHtml(html);
			writeFile(handleHtml);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String handleHtml(String html) {
		html = handleTags(html, BaseTagSupport.FOREACH_TAG);
		html = handleTags(html, BaseTagSupport.OUT_TAG);
		html = handleTags(html, BaseTagSupport.CHOOSE_TAG);
		html = handleTags(html, BaseTagSupport.IF_TAG);
		return html;
	}

	private static String handleTags(String html, BaseTagSupport tagSupport) {
		String tag = tagSupport.tagName();
		String javaRggex = "(<" + tag + ")([\\s\\S]*?)(</" + tag + ">)";
		Pattern pattern = Pattern.compile(javaRggex);
		Matcher matcher = pattern.matcher(html);
		while (matcher.find()) {
			String tagHtml = matcher.group();
			Document doc = null;
			StringBuilder sb = new StringBuilder();
			try {
				// 将字符串转为XML
				doc = DocumentHelper.parseText(tagHtml);
				// 获取根节点
				Element rootElt = doc.getRootElement();
				if (tagSupport instanceof ForEachTag) {
					doForEachTag(sb, rootElt);
				}
				else if (tagSupport instanceof OutTag) {
					doOutTag(sb, rootElt);
				}
				else if (tagSupport instanceof IfTag) {
					doIfTag(sb, rootElt);
				}
				else if (tagSupport instanceof ChooseTag) {
					doChooseTag(sb, rootElt);
				}
				html = html.replace(tagHtml, sb.toString());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return html;
	}

	private static void doChooseTag(StringBuilder sb, Element rootElt) {
		// 遍历子节点
		Boolean doOtherWise = false;
		Iterator<?> iter = rootElt.elementIterator();
		while (iter.hasNext()) {
			Element recordEle = (Element) iter.next();
			if ("when".equals(recordEle.getName())) {
				String testExpress = recordEle.attributeValue("test");
				String test = StringUtils.getStrValue(testExpress);

				if (test.contains(".")) {
					test = test.split("\\.")[0];
				}

				Object data = context.get(test);
				String ex = testExpress.replace("${", "").replace("}", "");
				// 遍历子节点
				Iterator<?> iterChild = recordEle.elementIterator();
				while (iterChild.hasNext()) {
					Element childEle = (Element) iterChild.next();
					String innerHtml = childEle.asXML();
					if (excuteTest(data, ex, test)) {
						sb.append(innerHtml);
					}
					else {
						doOtherWise = true;
						sb.append("");
					}
				}
			}
			if ("otherwise".equals(recordEle.getName())) {
				if (doOtherWise) {
					// 遍历子节点
					String innerHtml = recordEle.asXML();
					sb.append(innerHtml);
				}
			}
		}
	}

	private static void doIfTag(StringBuilder sb, Element rootElt) {
		String testExpress = rootElt.attributeValue("test");
		String test = StringUtils.getStrValue(testExpress);
		String token = ".";
		if (test.contains(token)) {
			test = test.split("\\.")[0];
		}

		Object data = context.get(test);
		String ex = testExpress.replace("${", "").replace("}", "");
		// 遍历子节点
		Iterator<?> iter = rootElt.elementIterator();
		while (iter.hasNext()) {
			Element recordEle = (Element) iter.next();
			String innerHtml = recordEle.asXML();
			if (excuteTest(data, ex, test)) {
				sb.append(innerHtml);
			}
			else {
				sb.append("");
			}
		}
	}

	private static void doOutTag(StringBuilder sb, Element rootElt) {
		String value = StringUtils.getStrValue(rootElt.attributeValue("value"));
		String data = (String) context.get(value);
		sb.append(handleExpression(rootElt.asXML(), data));
	}

	private static void doForEachTag(StringBuilder sb, Element rootElt) {
		Iterator<?> iter = rootElt.elementIterator();
		String items = rootElt.attributeValue("items");
		items = items.split("}")[0].substring(items.indexOf("{") + 1).trim();
		String var = rootElt.attributeValue("var").trim();
		@SuppressWarnings("unchecked")
		List<Object> kvList = (List<Object>) context.get(items);
		// 遍历子节点
		while (iter.hasNext()) {
			Element recordEle = (Element) iter.next();
			String innerHtml = recordEle.asXML();
			if (kvList != null && kvList.size() > 0) {
				for (Object data : kvList) {
					sb.append(handleExpression(innerHtml, var, data));
				}
			}
		}
	}

	private static boolean excuteTest(Object arg1, String test, String alias) {
		if (ReflectUtils.isBaseType(arg1)) {
			Expression compiledExp = AviatorEvaluator.compile(test);
			Map<String, Object> env = new HashMap<String, Object>(1);
			env.put(alias, arg1);
			return (boolean) compiledExp.execute(env);
		}
		else {
			Map<String, Object> env = new HashMap<String, Object>(1);
			env.put(alias, arg1);
			return (boolean) AviatorEvaluator.execute(test, env);
		}
	}

	private static Object handleExpression(String xml, String data) {
		xml = xml.replace(xml, String.valueOf(data));
		return xml;
	}

	public static String handleExpression(String innerHtml, String var, Object data) {
		String javaRggex = "\\$\\{[^}]+\\}";
		Pattern pattern = Pattern.compile(javaRggex);
		Matcher matcher = pattern.matcher(innerHtml);
		while (matcher.find()) {
			String nameOld = matcher.group();
			String name = nameOld;
			name = name.split("}")[0].substring(name.indexOf("{") + 1).trim();
			String[] express = name.split("\\.");
			if (var.equals(express[0])) {
				Object value = ReflectUtils.invokeGet(data, express[1]);
				innerHtml = innerHtml.replace(nameOld, String.valueOf(value));
			}
			else {
				continue;
			}
		}
		return innerHtml;
	}

	/**
	 * 写入文件
	 */
	public static void writeFile(String context) {
		try {
			File writeName = new File("src\\main\\java\\output.html");
			// 创建新文件,有同名的文件的话直接覆盖
			writeName.createNewFile();
			FileWriter writer = new FileWriter(writeName);
			BufferedWriter out = new BufferedWriter(writer);
			out.write(context);
			// 把缓存区内容压入文件
			out.flush();
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PageRendering.render("jstl.html");
	}

}
