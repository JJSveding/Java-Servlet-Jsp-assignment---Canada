<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration User Creation</title>
<link rel='stylesheet' type='text/css' href='css/styleSheet.css'>
<link rel='stylesheet' type='text/css' href='css/bootstrap.css'>
</head>
<body>
	<h1><label>Username information</label></h1>
			
 	<form method='post' action='RegisterUserServlet' >
		<div>
			<label>Username: </label>		
			<input type='text' name='username' value='${user.username}'><br>
	 		<label id='validationLabel'> ${errMsg.username}</label>

		</div>

		<div>
			<label>Password: </label>
			<input type='password' name='password'><br>
	 		<label id='validationLabel'>  ${errMsg.password} </label>		
		</div>

		<div>
			<label>Re-enter password: </label>
			<input type='password' name='rePassword'>
		</div>

		<div>
			<input type = submit value = 'Confirm username information'>
		</div>

	</form>

	<ul>
		<li><a >Personal</a></li>
		<li><a class='active' >Username</a></li>
		<li><a>Register</a></li>
	</ul>
</body>
</html>