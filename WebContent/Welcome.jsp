<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome page</title>
<link rel='stylesheet' type='text/css' href='css/bootstrap.css'>
<link rel='stylesheet' type='text/css' href='css/minorAdj.css'>
<script src="javascript/bootstrap.js"></script>
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
	
	<h1><a href="/assignment2/post.jsp" >Write a post</a></h1>
	<hr>
	
	<div class="container">
	<div class="panel panel-primary">
		<c:forEach var="posts" items="${allposts}" >
		 <div class="panel-heading">
			<p> ${posts.user} - ${posts.ts} </p>
	     </div>
			<div class="panel-body"> 
			   <p>${posts.text }</p>
			   		<span class="comments">
				       <c:forEach var="commentss" items="${posts.comments}">
				       			<p>
				       				${commentss.user}
				       				 Says - 
				       				${commentss.text}
				       			</p>
				       </c:forEach>
			       </span>
		       <form action="CommentServlet" method="post">
		       		<textarea class="form-control" rows="2" id="comment" name="comment" placeholder="Write your comment here"></textarea><br><br>
		       		<input type="hidden" value="${posts.id}" name="post_id">
		       		<input type="submit" class="btn btn-success">
		       </form>
		       
		     </div>
		 </c:forEach>
		 
	</div><br>
	</div>
</body>
</html>