<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="AdminHome.jsp"/>

<c:if test="${!empty drivers}">

<table>

<c:forEach items="${drivers}" var="driver">
<tr>
<td>Driver ID</td>
<td><c:out value="${driver.id}"></c:out></td>
</tr>
<tr>
	<td>Driver Name</td>
	<td><c:out value="${driver.name}"></c:out></td>
</tr>
<tr>
	<td>Driver Email</td>
	<td><c:out value="${driver.email}"></c:out></td>
</tr>
<tr>
	<td>Driver Vehicle No</td>
	<td><c:out value="${driver.v_no}"></c:out></td>
</tr>
<tr>
	<td>Driver Vehicle Type</td>
	<td><c:out value="${driver.v_type}"></c:out></td>
</tr>
<tr>
	<td>Driver Mobile No</td>
	<td><c:out value="${driver.mob}"></c:out></td>
</tr>


</c:forEach>


</table>
</c:if>
</body>
</html>