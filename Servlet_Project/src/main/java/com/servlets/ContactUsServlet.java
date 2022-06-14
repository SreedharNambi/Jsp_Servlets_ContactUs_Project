package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoclass.RequestDao;
import com.pojoclass.Request;

@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("contactus.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
			throws ServletException, IOException {
		String name = servletRequest.getParameter("user");
		String email = servletRequest.getParameter("email");
		String message = servletRequest.getParameter("message");

		Request request = new Request();
		request.setName(name);
		request.setEmail(email);
		request.setMessage(message);

		RequestDao requestDao = new RequestDao();
		requestDao.createRequest(request);		
	}
}
