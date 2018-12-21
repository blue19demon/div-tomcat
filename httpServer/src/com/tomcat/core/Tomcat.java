package com.tomcat.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Tomcat {

	private ServerSocket serverSocket = null;

	public static void main(String[] args) {
		Tomcat tomcat = new Tomcat(8888);
		tomcat.start();
	}

	public Tomcat(Integer port) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void start() {
		while (true) {
			HttpResponse response = null;
			int code = 200;
			try {
				Socket socket = serverSocket.accept();
				response = new HttpResponse(socket);
				HttpRequest request = new HttpRequest(socket.getInputStream());
				HttpServlet servlet = WebContext.getServlet(request.getUrl());
				if("/favicon.ico".equals(request.getUrl())) {
					continue;
				}
				if (servlet == null) {
					code = 404;
				} else {
					servlet.doGet(request, response);
				}

			} catch (IOException e) {
				code = 500;
			}
			response.pushToClient(code);
		}
	}
}
