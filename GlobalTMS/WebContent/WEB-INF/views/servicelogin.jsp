<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>					
		 		
<h4>Service Desk Login here</h4>
${mymsg}
</div>
<div>

<c:url var="saveCustUrl" value="/service/login.html" />
<form:form modelAttribute="serviceDesk" method="POST" action="${saveCustUrl}">
	
	<table cellpadding="10" style="font-family: inherit;font-size: medium;">
	<tr><td><form:label path="user_id"><b>User Id:</b></form:label></td>
	<td><form:input path="user_id" /></td></tr>
	<tr><td><form:label path="password"><b>Password</b></form:label></td>
	<td><form:password path="password"/> </td></tr>
	<tr><td><input type="submit" value="Login" /></td><td></td></tr>
	</table>
	
</form:form>
</div>
</body>
</html>