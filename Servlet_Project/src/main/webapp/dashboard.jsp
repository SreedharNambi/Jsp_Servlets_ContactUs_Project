<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Active User Requests</title>
</head>
<body>

	<h1>Active User Requests</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Message</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="data" items="${activeUserRequests}">
				<tr>
					<td><c:out value="${data.id}" /></td>
					<td><c:out value="${data.name}" /></td>
					<td><c:out value="${data.email}" /></td>
					<td><c:out value="${data.message}" /></td>
					<td><c:out value="${data.status}" /></td>
					<td><form action='dashboard' method='post'>
							<button name='btn' value="${data.id}">Archieve</button>
						</form></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h1>Archieved User Requests</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Message</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="data" items="${archievedUserRequests}">
				<tr>
					<td><c:out value="${data.id}" /></td>
					<td><c:out value="${data.name}" /></td>
					<td><c:out value="${data.email}" /></td>
					<td><c:out value="${data.message}" /></td>
					<td><c:out value="${data.status}" /></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>