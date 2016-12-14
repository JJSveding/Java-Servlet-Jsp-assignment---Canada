<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel='stylesheet' type='text/css' href='css/styleSheet.css'>
<link rel='stylesheet' type='text/css' href='css/bootstrap.css'>
</head>
<body>
 	<h1> <label>Login</label></h1>
 	
	 <label id='validationLabel' style="color: red"> ${errMsg}</label>

	<form method='post' action='AuthenticateServlet'>	
		<div>
			<label>Username: </label>
			<input type='text' name='username'>
		</div>
		
		<div>
			<label>Password: </label>
			<input type='password' name='password'>
		</div> 
	
		<div>
			<label>Remember me: </label>
			<input type='radio' name='remenberMe'  value='yes'>
		</div> 
	
		<div>
			<a href='Register.jsp' class="login" >Register</a>-or-
			<input type='submit' value='Login' id='login'>
		</div>
	</form>

</body>
</html>