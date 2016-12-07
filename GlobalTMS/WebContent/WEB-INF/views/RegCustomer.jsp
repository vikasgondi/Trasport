<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
 <jsp:include page="header.jsp"/>

<div align="right" >
 <a  href="/GlobalTMS/login.html">Login Here</a>


</div>


${mymsg}

<div>
<c:url var="saveCustUrl" value="/customer/save" />
<form:form  modelAttribute="customer" method="POST" action="${saveCustUrl}" >
	<table align="left" cellspacing="10"  style="background-color:transparent; color: gray;;"  >
	
<tr><td>	<form:label path="email"><b>Email Id:</b></form:label></td>
	<td><form:input path="email" /></td> <td><form:errors
				path="email" /></td></tr>
	
<tr><td><form:label path="name"><b>Name:</b> </form:label></td>
	<td><form:input path="name" /></td><td><form:errors
				path="name" /></td></tr>
	 
<tr><td><form:label path="password"><b>Password</b></form:label></td>
<td><form:password path="password"/> </td><td><form:errors
				path="password" /></td></tr>
	
<tr><td><form:label path="address"><b>Address</b></form:label></td>
<td><form:input path="address"/></td></tr>
	
<tr><td><form:label path="mob"><b>Mobile No</b></form:label></td>
	<td><form:input path="mob"/></td><form:errors
				path="mob" /></tr>
	<tr><td><td><input  type="submit" value="Register" /></td></tr>
</table>
</form:form>
</div>

</body>
</html>