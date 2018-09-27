package com.dispatch.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet001")
public class Servlet001 extends HttpServlet {

	// -- Not used, just Servlet sample. --

	// Servlet class usually extends HttpServlet. All other classes, including
	// POJOs, Beans, Domain classes, or other not Web Interface classes are not
	// considered servlet classes. They can however be part of a servlet.
	// Servlet corresponds a Controller JavaBean corresponds a Model. Component
	// architecture for encapsulating functionality.
	// Sessions are the servlet mechanism for storing objects related to a
	// particular user, these objects may or may not be beans.
	// Enterprise JavaBeans were mostly replaced by "Pojos" popularized by IoC
	// Containers (like Spring in 2003). IoC pulled back Javabean to its former
	// concept. IoC replaced the overall EJB-J2EE Templating pattern, Service
	// Locator, Business Delegate patterns to a simple Injection of Dependencies
	// (DI).
	
	private static final long serialVersionUID = 1L;

	public Servlet001() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("From Servlet001 sample. Served at: {").append(request.getContextPath() + "}");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
