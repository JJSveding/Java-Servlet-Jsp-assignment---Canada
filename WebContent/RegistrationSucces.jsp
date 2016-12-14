<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Success!</title>
<link rel='stylesheet' type='text/css' href='css/styleSheet.css'>
<link rel='stylesheet' type='text/css' href='css/bootstrap.css'>
</head>
<body>
 	<h1><label>Congratulations, ${user.fName}</label></h1>
		<div>
			<label> Your registration is now complete </label><br>
 			<a href='Login.jsp' class='succes'>Back to Login page</a>
		</div>


	<ul>
		<li><a >Personal</a></li>
		<li><a >Username</a></li>
		<li><a class='active'>Register</a></li>
	</ul>
</body>
</html>