<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill</title>
</head>
<body>

<jsp:include page="serviceHome.jsp"/>
<c:url var="saveCustUrl" value="/service/bookdetail" />

<h3>${mymsg}</h3>
<form:form modelAttribute="booking"  method="POST" action="${saveCustUrl}" >
	<table cellpadding="10">

	<tr><td><form:label path="b_id">Booking Id</form:label></td>
	<td><form:input path="b_id"/></td></tr>
	<tr><td><input type="submit" value="Get"/></td></tr>
</table>
</form:form>
<form:form modelAttribute="driver"  method="POST" action="${saveCustUrl}" >
	<table cellpadding="10">

		<tr>
			<td><form:label path="driver_id">Driver Id</form:label></td>
			<td><form:input path="driver_id"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Get"/></td>
		</tr>
	</table>
	</form:form>
<form:form modelAttribute="customer"  method="POST" action="${saveCustUrl}" >
	<table cellpadding="10">

		<tr>
			<td><form:label path="email">Customer E mail</form:label></td>
			<td><form:input path="email"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Get"/></td>
		</tr>
	</table>
</form:form>
			
</body>
</html>