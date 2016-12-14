<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Post</title>
<link rel='stylesheet' type='text/css' href='css/bootstrap.css'>
</head>
<body>

	<div class="navbar navbar-dark bg-primary">
	   <span class="navbar-text">
	    	Welcome, ${user.fName} ${user.lName}!
	   </span>
	   <span class="navbar-text float-xs-right">
		   <b><a href='AuthenticateServlet' style="color:white">Home</a></b>
  	   </span>
	   <span class="navbar-text float-xs-right">
		   <b><a href='/assignment2/LogoutServlet' style="color:white">Logout</a></b>
  	   </span>
	</div>
	
	<div class="container">
		<form action="PostServlet" method="post" class="form-group">
			<h1>New Post</h1>
			<textarea class = "form-control"rows="8" cols="100" name="post" placeholder="Enter post here"></textarea><br>
			<input type="submit" value="Submit" class="btn btn-primary">
		</form>
	</div>
</body>
</html>