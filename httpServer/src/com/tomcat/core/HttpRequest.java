package com.tomcat.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpRequest {

	private String url;

	private Map<String, List<String>> parameterMapValues;

	private static final String CRT = "\r\n";

	private String requestInfo;

	public HttpRequest() {
		super();
		url = "";
		parameterMapValues = new HashMap<String, List<String>>();
		requestInfo = "";
	}

	public HttpRequest(InputStream inputStream) {
		this();
		byte[] data = new byte[20480];
		int len;
		try {
			len = inputStream.read(data);
			requestInfo = new String(data, 0, len);
		} catch (IOException e) {
			return;
		}
		handleInfo();
	}

	private void handleInfo() {
		if ("".equals(requestInfo)) {
			return;
		}
		String param = "";
		String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRT));
		int idx = firstLine.indexOf("/");
		String methodType = firstLine.substring(0, idx);
		String url = null;
		if ("get".equalsIgnoreCase(methodType)) {
			url = firstLine.substring(idx, firstLine.indexOf("?"));
			if (firstLine.contains("?")) {
				String par = firstLine.substring(firstLine.indexOf("?") + 1, firstLine.indexOf("HTTP/1.1"));
				param = par;
			} else {
				url = firstLine.substring(idx, firstLine.indexOf("HTTP/1.1"));
			}
		} else {
			url = firstLine.substring(idx, firstLine.indexOf("HTTP/1.1")).trim();
			param = requestInfo.substring(requestInfo.lastIndexOf(CRT)).trim();
		}
		this.url = url;
		if (!"".equals(param)) {
			praseParam(param);
		} else {
			return;
		}
	}

	public String[] getParamaterValues(String name) {
		return parameterMapValues.containsKey(name) ? parameterMapValues.get(name).toArray(new String[0]) : null;
	}

	public String getParamater(String name) {
		return parameterMapValues.containsKey(name) ? parameterMapValues.get(name).get(0) : null;
	}

	private void praseParam(String paramString) {
		try {
			String[] stringTokenizer =paramString.split("\\&");
			for (String item : stringTokenizer) {
				String[] keyValues = item.split("=");
				if (keyValues.length == 1) {
					keyValues = Arrays.copyOf(keyValues, 2);
				}
				String key = keyValues[0].trim();
				String value = keyValues[1] == null ? null : URLDecoder.decode(keyValues[1], "UTF-8");
				List<String> values = parameterMapValues.get(key);
				if (parameterMapValues.containsKey(key)) {
					values.add(value);
				} else {
					values = new ArrayList<String>();
					values.add(value);
				}
				parameterMapValues.put(key, values);
			}
		} catch (UnsupportedEncodingException e) {
			return;
		}
	}

	public String getUrl() {
		return url;
	}
	
	
	public void getRequestDisparcher(String page,HttpRequest request,HttpResponse response) {
		String filePath="./WEB-INF"+page;
		byte[] data = new byte[20480];
		String src="";
		FileInputStream inputStream=null;
		int len;
		try {
			inputStream=new FileInputStream(new File(filePath));
			len = inputStream.read(data);
			src = new String(data, 0, len);
		} catch (IOException e) {
			return;
		}finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		response.print(src);
	}
	
}
