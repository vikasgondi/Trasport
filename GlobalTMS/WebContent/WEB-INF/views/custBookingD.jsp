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
<jsp:include page="CustomerHome.jsp"/> 

 <c:if test="${!empty bookings1}"> 
 <table border="1" cellpadding="10" align="left" style="border-color: blue;left; border-style: groove;text-decoration: blink;" >
		<tr>
			<th>Book ID</th>
			<th>Vehicle Type</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Payed Amount</th>
			<th>Driver Id</th>
			<th>Driver Name</th>
			<th>Driver email</th>
			<th>Vehicle No</th>
		
			
		</tr>

		 <c:forEach items="${bookings1}" var="booking"> 
			<tr>
			
				<td><c:out value="${booking.b_id}"/></td>
				<td><c:out value="${booking.v_type}"/></td>
				<td><c:out value="${booking.s_date}"/></td>
				<td><c:out value="${booking.e_date}"/></td>
				<td><c:out value="${booking.e_amount}"></c:out>
				
				<td><c:out value="${booking.driver.driver_id}"/></td>
				<td><c:out value="${booking.driver.d_name}"/></td>
				<td><c:out value="${booking.driver.email}"/></td>
				<td><c:out value="${booking.driver.vehicle_no}"/></td>
		
				
			</tr>
			
		</c:forEach> 
	</table>
	<br/>
</c:if>
<c:if test="${empty bookings1}"> 

<b>No record found </b>
</c:if>
</body>
</html>