package com.tomcat.core;

public abstract class HttpServlet {
	
	protected  void service(HttpRequest request,HttpResponse response) {
		doPost(request, response);
		doGet(request, response);
	}
	protected abstract void doPost(HttpRequest request,HttpResponse response);
	protected abstract void doGet(HttpRequest request,HttpResponse response);
}
