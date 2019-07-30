package com.tomcat.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
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

	private String requestMethod;
	
	public HttpRequest() {
		super();
		url = "";
		parameterMapValues = new HashMap<String, List<String>>();
		requestInfo = "";
		requestMethod = "GET";
	}

	public HttpRequest(Socket socket) {
		this();
		byte[] data = new byte[20480];
		int len;
		try {
			InputStream inputStream= socket.getInputStream();
			len = inputStream.read(data);
			requestInfo = new String(data, 0, len);
			handleInfo();
		} catch (IOException e) {
			return;
		}
		
	}

	private void handleInfo() {
		try {
			if ("".equals(requestInfo)) {
				return;
			}
			String param = "";
			String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRT));
			int idx = firstLine.indexOf("/");
			String methodType = firstLine.substring(0, idx).trim();
			this.requestMethod = methodType;
			String url = null;
			if ("GET".equalsIgnoreCase(methodType)) {
				if (firstLine.contains("?")) {
					url = firstLine.substring(idx, firstLine.indexOf("?")).trim();
					String par = firstLine.substring(firstLine.indexOf("?") + 1, firstLine.indexOf("HTTP/1.1")).trim();
					param = par;
				} else {
					url = firstLine.substring(idx, firstLine.indexOf("HTTP/1.1")).trim();
				}
			} else {
				url = firstLine.substring(idx, firstLine.indexOf("HTTP/1.1")).trim().trim();
				param = requestInfo.substring(requestInfo.lastIndexOf(CRT)).trim();
			}
			this.url = url;
			if (!"".equals(param)) {
				praseParam(param);
			} else {
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	
	
	public String getRequestMethod() {
		return requestMethod;
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
