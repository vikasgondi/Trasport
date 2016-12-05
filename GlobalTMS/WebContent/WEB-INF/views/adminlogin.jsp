<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/customerlogin.css" />

 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
	

<title>Global Transport Management System</title>
 
</head>
<body>

${mymsg}

<div class="login-page">
  <div class="form">
		<h2 style="color: black;"> Admin Login Here</h2>
			<c:url var="saveCustUrl" value="/admin/loginadmin.html" />
			<form:form modelAttribute="admin" method="POST" action="${saveCustUrl}">
	
				<table cellpadding="10" style="font-family: inherit;font-size: medium;">
	
					<tr><td><form:label path="u_name"><b>User Id:</b></form:label></td>
					<td><form:input path="u_name" /></td></tr>
	
					<tr><td><form:label path="password"><b>Password</b></form:label></td>
					<td><form:password path="password"/> </td></tr>
					
					<tr><td><input type="submit" value="Login" /></td><td></td></tr>
				</table>
	
			</form:form>
	</div>
  </div>
</body>
</html>



