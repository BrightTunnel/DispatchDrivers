package com.dispatch.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReportToDispatch")
public class ReportToDispatch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReportToDispatch() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String formToDisplay = "<html><head><title>Message To Dispatch</title>"
				+ "<link rel=\"stylesheet\" href=\"style.css\">" + "</head><body>" + "<br><h2>Message To Dispatch</h2>"
				+ "<textarea rows='16' cols='64' name='NoteToDispatch' form='idFrmReportToDispatch'></textarea><br><br>"
				+ "<form action='' id='idFrmReportToDispatch'>Print your name: <input type='text' name='DriverId' /> "
				+ "<input type='submit' value='Submit Report' />" + "</form><br><a href=\"index.jsp\">Dashboard</a>"
				+ "</body></html>";
		response.getWriter().append(formToDisplay);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
