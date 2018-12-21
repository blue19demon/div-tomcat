package com.tomcat.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class WebContext {

	private static Map<String, String> servletContext = new HashMap<>();
	private static Map<String, String> servletMappingContext = new HashMap<>();
	static {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(".\\WEB-INF\\web.xml"));
		} catch (FileNotFoundException e) {
			
		}
		initContext(inputStream);
	}

	@SuppressWarnings("unchecked")
	private static void initContext(InputStream inputStream) {
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(inputStream);
			Element root = document.getRootElement();
			// servlets
			List<Element> servlets = root.element("servlets").elements("servlet");
			if (!servlets.isEmpty()) {
				for (Element child : servlets) {
					servletContext.put(child.elementText("servlet-name"), child.elementText("servlet-class"));
				}
			}
			// servlet-mapping
			List<Element> servletMappings = root.elements("servlet-mapping");
			if (!servlets.isEmpty()) {
				for (Element child : servletMappings) {
					servletMappingContext.put(child.elementText("url-pattern"), child.elementText("servlet-name"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static HttpServlet getServlet(String url) {
		try {
			String servlet_name=servletMappingContext.get(url);
			if("".equals(servlet_name)||servlet_name==null) {
				return null;
			}
			return (HttpServlet) Class.forName(servletContext.get(servlet_name)).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
