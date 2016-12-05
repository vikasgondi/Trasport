<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/5grid/core.css" />


	 
<title>GTMS</title>
</head>
<body >
<jsp:forward page="login"/>
						
 <div  style="background-color:teal;font-size: medium;" > 

<center><h1>Welcome to Global Transport Management System</h1></center>
  </div> 

	<div class="4u">
	<a href="customer" ><h4>Sign Up </h4></a>	
    <a  href="login.html"><h4>Login Here</h4></a>
    <a href="admin.html"><h4>Admin</h4></a>
    <a href="service"><h4>Service Desk</h4></a>
  </div>
  <div>

  <%-- <c:url var="saveCustUrl" value="/login/loginCustomer.html" />
<form:form commandName="customer" method="POST" action="${saveCustUrl}">
	
	<table cellpadding="10" style="font-family: inherit;font-size: medium;">
	<tr><td><form:label path="email"><b>Email Id:</b></form:label></td>
	<td><form:input path="email" /></td></tr>
	<tr><td><form:label path="password"><b>Password</b></form:label></td>
	<td><form:password path="password"/> </td></tr>
	<tr><td><input type="submit" value="Login" /></td><td></td></tr>
	</table>
	
</form:form> --%>
  </div>
 
</body>
</html>