package com.tomcat.core;

import java.io.IOException;
import java.net.Socket;

import com.tomcat.servlets.LoginServlet;

public class HttpServletDisparcher implements Runnable {

	private Socket socket;
	private HttpRequest request;
	private HttpResponse response;
	public HttpServletDisparcher(Socket socket) {
		super();
		try {
			this.socket = socket;
			request=new HttpRequest(socket.getInputStream());
			response=new HttpResponse(socket);
		} catch (IOException e) {
			return;
		}
		
	}

	@Override
	public void run() {
		try {
			HttpServlet servlet=new LoginServlet();
			servlet.service(request, response);
		} catch (Exception e) {
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
