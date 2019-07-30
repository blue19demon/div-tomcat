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

import com.test.KV;
import com.test.tag.ChooseTag;
import com.test.tag.ForEachTag;
import com.test.tag.OutTag;
import com.test.tag.TagSupport;
import com.test.tools.ReflectUtils;
import com.test.tools.StringUtils;

public class PageRendering {

	private static Map<String,Object> context = new HashMap<String, Object>();
	static {
		List<Object> kvList = Arrays.asList(new KV("01", "值1"), new KV("02", "值2"), new KV("03", "值3"),
				new KV("04", "值4"), new KV("05", "值5"), new KV("06", "值61"));
		context.put("kvList", kvList);
		context.put("salary", "10000");
		context.put("name", "张安");
	}

	public static void render(String cxtPath) {
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(cxtPath);
			InputStreamReader reader = new InputStreamReader(is); // 建立一个输入流对象reader
			BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String handleHtml(String html) {
		html = handleTags(html,TagSupport.FOREACH_TAG);
		html = handleTags(html,TagSupport.OUT_TAG);
		html = handleTags(html,TagSupport.CHOOSETAG_TAG);
		return html;
	}

	@SuppressWarnings("unchecked")
	private static String handleTags(String html,TagSupport tagSupport) {
		String tag = tagSupport.tagName();
		String JAVARGGEX = "(<" + tag + "[^>])([\\s\\S]*?)(</" + tag + ">)";
		Pattern pattern = Pattern.compile(JAVARGGEX);
		Matcher matcher = pattern.matcher(html);
		while (matcher.find()) {
			String tagHtml = matcher.group();
			Document doc = null;
			StringBuilder sb = new StringBuilder();
			try {
				doc = DocumentHelper.parseText(tagHtml); // 将字符串转为XML
				Element rootElt = doc.getRootElement(); // 获取根节点
				if(tagSupport instanceof ForEachTag) {
					Iterator<?> iter = rootElt.elementIterator(); // 获取根节点下的子节点head
					// 遍历节点
					while (iter.hasNext()) {
						String items = rootElt.attributeValue("items");
						items = items.split("}")[0].substring(items.indexOf("{") + 1).trim();
						String var = rootElt.attributeValue("var").trim();
						List<Object> kvList = (List<Object>) context.get(items);
						Element recordEle = (Element) iter.next();
						String innerHtml = recordEle.asXML();
						if (kvList != null && kvList.size() > 0) {
							for (Object data : kvList) {
								sb.append(handleExpression(innerHtml, var, data));
							}
						}
					}
				}else if(tagSupport instanceof OutTag) {
					String value = StringUtils.get$StrValue(rootElt.attributeValue("value"));
					String data = (String) context.get(value);
					sb.append(handleExpression(rootElt.asXML(),data));
				}else if(tagSupport instanceof ChooseTag) {
					
				}
				html = html.replace(tagHtml, sb.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return html;
	}

	private static Object handleExpression(String asXML,String data) {
		asXML = asXML.replace(asXML, String.valueOf(data));
		return asXML;
	}

	public static String handleExpression(String innerHtml, String var, Object data) {
		String JAVARGGEX = "\\$\\{[^}]+\\}";
		Pattern pattern = Pattern.compile(JAVARGGEX);
		Matcher matcher = pattern.matcher(innerHtml);
		while (matcher.find()) {
			String name_old = matcher.group();
			String name = name_old;
			name = name.split("}")[0].substring(name.indexOf("{") + 1).trim();
			String[] express = name.split("\\.");
			if (var.equals(express[0])) {
				Object value = ReflectUtils.invokeGet(data, express[1]);
				innerHtml = innerHtml.replace(name_old, String.valueOf(value));
			} else {
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
			File writeName = new File("src\\main\\java\\output.html"); // 相对路径，如果没有则要建立一个新的output.txt文件
			writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
			FileWriter writer = new FileWriter(writeName);
			BufferedWriter out = new BufferedWriter(writer);
			out.write(context);
			out.flush(); // 把缓存区内容压入文件
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PageRendering.render("jstl.html");
	}
}
