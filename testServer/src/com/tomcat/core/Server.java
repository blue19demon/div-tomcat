package com.tomcat.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket serverSocket = null;

	public static void main(String[] args) {
		Server tomcat = new Server(8888);
		tomcat.start();
	}

	public Server(Integer port) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void start() {
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				new Thread(new HttpServletDisparcher(socket)).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
