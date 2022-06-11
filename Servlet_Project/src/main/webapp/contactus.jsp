<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

body{
background-color:#c2c0bc;
}

input{
width:100%;

}

textarea{
width:100%;
height:25vh;}
span{
color:red;
}

.contact-card{
background-color:white;
width:50%;
margin:auto;
display:flex;
flex-direction:column;
justify-content:center;
align-items:center;
padding-bottom:15x;
height:auto;
padding-top:10px;
}

#email-tagline{
color:#94908a;
text-align:left;
font-size:10px;
}
h1,p{
text-align:center;
background-color:transparent;
}
#submit-btn{
margin-bottom:5px;
width:20vw;}


</style>

</head>
<body>
		
	<div>
	<div class='card-heading'>
	<h1>Contact Us</h1>
		<p>Please fill this form in a decent manner</p>
	</div>
		
		<form class='contact-card' action="contactus" method='post'>
		<label for='user'>Name <span>*</span><input id='user' type=text required name='user'></label><br>
		<label for='email'>E-mail <span>*</span><input id='email' type=text required name='email'></label>
		<span id='email-tagline'>example@example.com</span><br>
		<label for='message'>Message <span>*</span><textarea id='message' required name='message'></textarea></label>
		
		<input id='submit-btn' type='submit'>
		
		</form>
		
	</div>
		
		
		
		
</body>
</html>