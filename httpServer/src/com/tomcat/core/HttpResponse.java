package com.tomcat.core;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class HttpResponse {

	/**
	 * 流
	 */
	private BufferedWriter bufferedWriter;

	private Integer status;
	/**
	 * 正文
	 */
	private StringBuilder content;
	/**
	 * 正文长度
	 */
	private Integer contentLength;

	/**
	 * 头信息
	 */
	private StringBuilder headInfo;

	private static final String CRT = "\r\n";

	private static final String BLANK = " ";

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public HttpResponse() {
		super();
	}

	public HttpResponse(Socket socket) {
		this();
		try {
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			this.status=500;
		}
		contentLength = 0;
		headInfo = new StringBuilder();
		content = new StringBuilder();
	}

	public void createHead(Integer status) {
		try {
			String responseStatus = "OK";
			switch (status) {
			case 200:
				responseStatus = "OK";
				break;
			case 404:
				responseStatus = "RESUORCE NOT FOUND";
				break;
			case 500:
				responseStatus = "SERVER ERROR";
				break;
			default:
				responseStatus = "OK";
				break;
			}
			headInfo.append("HTTP/1.1").append(BLANK).append(status).append(" " + responseStatus).append(CRT);
			headInfo.append("Server:mytomcat Server/1.0.0").append(CRT);
			headInfo.append("Date:").append(BLANK).append(new Date()).append(CRT);
			headInfo.append("Content-Type:").append(BLANK).append("text/html;charset=UTF-8").append(CRT);
			headInfo.append("Content-Length:").append(BLANK).append(contentLength).append(CRT);
			headInfo.append(CRT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HttpResponse print(String src) {
		content.append(src).append(CRT);
		contentLength+=(src+CRT).getBytes().length;
		return this;
	}

	public void pushToClient(Integer code) {
		try {
			createHead(code);
			bufferedWriter.append(headInfo);
			bufferedWriter.append(content);
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
