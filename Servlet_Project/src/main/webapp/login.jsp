<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.admin-page {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>

	<div class="admin-page">
		<h1>Admin Login</h1>
		<form class='admin-page' action="" method="post">
			<label for='username'> Username<br>
			<input id='username' type='text' name='username' required></label><br>
			<label for='password'>Password<br>
			<input id='password' type='password' name='password' required></label><br>
			<input type='submit' value='Login'>
		</form>
	</div>

</body>
</html>