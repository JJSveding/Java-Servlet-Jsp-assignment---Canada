<%@ page language="java" contentType="text/html charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html charset=ISO-8859-1">
<title>Registration</title>
<link rel='stylesheet' type='text/css' href='css/styleSheet.css'>
<link rel='stylesheet' type='text/css' href='css/bootstrap.css'>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	
	
	<h1><label>Personal Information</label></h1>
		 	
	<form method='post' action='RegisterServlet'>
 		<div>
 			<label>First Name: </label>
			<input type='text' name='fName' value='${incUser.fName}'><br>
			<label id='validationLabel'> ${errMsg.fName} </label>
 		</div>
		
		<div>
			<label>Last Name: </label>
			<input type='text' name='lName' value='${incUser.lName}'><br>
			<label id='validationLabel'> ${errMsg.lName} </label>
 		</div>
 		
 		<div>
 			<label>E-mail: </label> 
			<input type='text' name='email' value='${incUser.email}'><br>
			<label id='validationLabel'> ${errMsg.email}</label>
		</div>
		
		<div>
		 	<label>Confirm E-mail: </label>
								<input type='text' name='cEmail' value='${incUser.email}'><br>
		 		</div>
	
		
		<div>
 			<label>Telephone number: </label>
		   (<input type='text' name='areaCode' maxlength='3' size='3' id='txtPhone1' value='${not empty incUser.telephone ? fn:substring(incUser.telephone, 0, 3): ""}'>) -
			<input type='text' name='coCode' maxlength='3' size='3' id='txtPhone2' value='${not empty incUser.telephone ? fn:substring(incUser.telephone, 3, 6): ""}' > -
			<input type='text' name='stCode' maxlength='4' size='4' id='txtPhone3' value='${not empty incUser.telephone ? fn:substring(incUser.telephone, 6, 10): ""}' > 
			<label id='validationLabel'>${errMsg.telephone}</label>
 		</div>
	
		 		
		<div>
			<label>Year: </label>
			<select name='year' id='selectYear'>
			<option selected disabled>Select one</option>
				<c:forEach begin="1970" end="2016" varStatus="i">
					<option value="${i.index}" ${incUser.year == ""+i.index ? 'selected' : ''}>${i.index}</option>
				</c:forEach>
			</select><br>
			<label id='validationLabel'> ${errMsg.year}</label>
		</div>
		
		
		<div>
			<label>Major: </label>
			<select name='major' id='selectMajor'>
				<option selected disabled>Select one</option>
				<c:set var="majors">Aviation, Business, Engineering, History, Math</c:set> 
					<c:forTokens items="${majors}" delims="," var="major">
		 						<option value="${major}" ${incUser.major == major ? 'selected' : ''}>${major}</option>
					</c:forTokens>
			</select><br>
			<label id='validationLabel'> ${errMsg.major}</label>
		</div>
	
 		<div>
 			<input type = submit value = 'Proceed to incUser information'>
 		</div>

	</form>
		 
	 <ul>
			<li><a class='active' >Personal</a></li>
			<li><a >Username</a></li>
			<li><a>Register</a></li>
	</ul>
		
		
		
</body>
</html>