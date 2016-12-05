<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" href="css/style.css" /> -->
<title>Insert title here</title>

</head>
<body>
 <div >

<a href="/GlobalTMS/booking">Home</a>
<a href="/GlobalTMS/login.logout">Logout</a>

</div>
<div>

<h3>Your Booking Details<br>


 
	
			
		<table>
			<tr>
				<td>Book ID</td>
				<td><c:out value="${booking.b_id}"/></td>
			</tr>
			<tr>
				<td>Vehicle Type</td>
				<td><c:out value="${booking.v_type}"/></td>
			</tr>
			<tr>
				<td>Start Date</td>
				<td><c:out value="${booking.s_date}"/></td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><c:out value="${booking.e_date}"/></td>
				</tr>
			<tr>
				<td>Estimated Amount</td>
				<td><c:out value="${booking.e_amount}"/></td>
			</tr>
		
	<%-- 	</c:forEach> --%>
	</table>
Confirm for payment
<c:url var="saveCustUrl" value="/booking/confirm/${booking.b_id}" />
		<button onclick="location.href='${saveCustUrl}'">Confirm</button>
<br>

</div>
</body>
</html>