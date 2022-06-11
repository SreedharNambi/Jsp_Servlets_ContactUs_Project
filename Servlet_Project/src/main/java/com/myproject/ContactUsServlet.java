package com.myproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("contactus.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("user");
		String email = request.getParameter("email");
		String message = request.getParameter("message");

		Request newRequest = new Request();
		newRequest.setName(name);
		newRequest.setEmail(email);
		newRequest.setMessage(message);

		RequestDao requestdao = new RequestDao();
		requestdao.createRequest(newRequest);

		response.sendRedirect("reqsuccess.jsp");
	}

}
