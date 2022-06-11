package com.myproject;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDao reqObject = new RequestDao();
		ArrayList<Request> activeUserRequests = reqObject.getActiveUserRequestsData();
		ArrayList<Request> archievedUserRequests = reqObject.getArchievedUserRequestsData();

		request.setAttribute("archievedUserRequests", archievedUserRequests);
		request.setAttribute("activeUserRequests", activeUserRequests);

		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("btn"));
		RequestDao reqObject = new RequestDao();
		reqObject.updateStatus(id);
		ArrayList<Request> activeUserRequests = reqObject.getActiveUserRequestsData();
		ArrayList<Request> archievedUserRequests = reqObject.getArchievedUserRequestsData();

		request.setAttribute("archievedUserRequests", archievedUserRequests);
		request.setAttribute("activeUserRequests", activeUserRequests);

		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);

	}

}
