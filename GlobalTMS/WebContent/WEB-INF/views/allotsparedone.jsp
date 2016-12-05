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
<jsp:include page="adminhome.jsp"/><br>
<h3>Spare Driver allotted to customer</h3>
<div>
		<c:if test="${!empty bookings}">
			<table cellpadding="10 " border="1" bordercolor="blue">
				<c:forEach items="${bookings}" var="booking">
					<tr>
						<td>Booking Id</td>
						<td><c:out value="${booking.b_id}"/></td>
					</tr>
					<tr>
						<td>Customer Name</td>
						<td><c:out value="${booking.customer.name}"/></td>
					</tr>
					<tr>
						<td>Spare Driver Id</td>
						 <td><c:out value="${booking.spareD.id}"/></td> 
					</tr>
					<tr>
						<td>Spare Driver Name</td>
						<td><c:out value="${booking.spareD.name}"/></td>
					</tr>
					<tr>
						<td>Spare Driver Mobile No</td>
						<td><c:out value="${booking.spareD.mob}"></c:out></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
</div>
</body>
</html>