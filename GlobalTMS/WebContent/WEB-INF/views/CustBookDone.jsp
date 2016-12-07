<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 10px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}</style>
<title>Insert title here</title>
</head>
<body>
		<nav class="navbar navbar-inverse">
 			 <div class="container-fluid">
   				 <div class="navbar-header">
      						<a class="navbar-brand" href="/GlobalTMS/booking">Home</a>
      						<a class="navbar-brand" href="/GlobalTMS/booking/mybook">My Bookings</a>
   			 </div>
       		 <ul class="nav navbar-nav navbar-right">
     			 <li><a href="/GlobalTMS/login.logout"><span class="glyphicon glyphicon-user"></span>Logout</a></li>
         	 </ul>
 			 </div>
		</nav>
		
		
	<div>
				<h2>Your Payment Done Successfully. Please Check your E mail for invoice. </h2>
				Your Booking Id is:
				<c:out value="${booking.b_id}"/><br>
				<h3>Your booking details. </h3><br>
				 
					<table   border="1" cellpadding="10" align="left">
						
				
						 <c:forEach items="${bookings}" var="booking"> 
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
								<td>Payed Amount</td>
								<td><c:out value="${booking.e_amount}"/></td>
							</tr>
							
							<%-- <tr>
							<th>Driver Id</th>
							<th>Driver Name</th>
							<th>Driver email</th>
							<th>Vehicle No</th>
							
						</tr>
				
						
							<tr>
								<td><c:out value="${booking.driver.driver_id}"/></td>
								<td><c:out value="${booking.driver.d_name}"/></td>
								<td><c:out value="${booking.driver.email}"/></td>
								<td><c:out value="${booking.driver.vehicle_no}"/></td>
								
								
							</tr> --%>
							
						</c:forEach> 
					
					</table>
	</div>
Thank You :-)

Have a Great Day



</body>
</html>