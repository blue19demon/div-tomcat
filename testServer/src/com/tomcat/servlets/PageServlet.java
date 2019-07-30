package com.tomcat.servlets;

import com.tomcat.core.HttpRequest;
import com.tomcat.core.HttpResponse;
import com.tomcat.core.HttpServlet;

public class PageServlet extends HttpServlet{

	@Override
	protected void doPost(HttpRequest request, HttpResponse response) {
		request.getRequestDisparcher("/jsp/form.html", request, response);
	}

	@Override
	protected void doGet(HttpRequest request, HttpResponse response) {
		doPost(request, response);
	}

}
