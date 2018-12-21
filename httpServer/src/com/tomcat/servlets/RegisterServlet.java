package com.tomcat.servlets;

import com.tomcat.core.HttpRequest;
import com.tomcat.core.HttpResponse;
import com.tomcat.core.HttpServlet;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpRequest request, HttpResponse response) {
		this.doGet(request, response);
	}

	@Override
	protected void doGet(HttpRequest request, HttpResponse response) {
		response.print("<html charset='UTF-8'>\r\n" + 
				"<head>\r\n" + 
				"<title>Wrox Homepage</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"register \r\n" + request.getParamater("lastname")+
				"</body>\r\n" + 
				"</html>");
	}

}
