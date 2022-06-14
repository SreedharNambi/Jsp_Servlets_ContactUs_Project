package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoclass.RequestDao;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDao requestDao = new RequestDao();
		request.setAttribute("archivedUserRequests", requestDao.getArchivedUserRequests());
		request.setAttribute("activeUserRequests",requestDao.getActiveUserRequests());

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		Integer id = Integer.parseInt(request.getParameter("button"));
		RequestDao requestDao = new RequestDao();
		requestDao.updateStatus(id);
		
		request.setAttribute("archivedUserRequests", requestDao.getArchivedUserRequests());
		request.setAttribute("activeUserRequests",requestDao.getActiveUserRequests());

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
		requestDispatcher.forward(request, response);
	}
}
