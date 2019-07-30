package com.tomcat.core;

import java.io.IOException;
import java.net.Socket;

public class HttpServletDisparcher implements Runnable {

	private Socket socket;
	private HttpRequest request;
	private HttpResponse response;
	public HttpServletDisparcher(Socket socket) {
		super();
		try {
			this.socket = socket;
			request=new HttpRequest(socket);
			response=new HttpResponse(socket);
		} catch (Exception e) {
			return;
		}
	}

	@Override
	public void run() {
		int code = 200;
		try {
			HttpServlet servlet = WebContext.getServlet(request.getUrl());
			if (servlet == null) {
				code = 404;
			} else {
				if("/favicon.ico".equals(request.getUrl())) {
					return;
				}
				servlet.service(request, response);
			}
			response.pushToClient(code);
		} catch (Exception e) {
			code = 500;
			e.printStackTrace();
		}finally {
			if(socket!=null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
