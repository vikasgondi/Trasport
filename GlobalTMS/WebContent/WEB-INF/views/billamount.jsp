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

<title>Bill</title>
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
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Service Desk</a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="">Home</a></li>
      
     

      
     
 <li class="active"><a href="/GlobalTMS/service/bill">Bill</a></li>
 <li><a href="/GlobalTMS/service/bookdetail">Booking Detail</a></li>
      
     
      

        
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/GlobalTMS/service.logout""><span class="glyphicon glyphicon-user"></span> Log out</a></li>
          </ul>
  </div>
</nav>				

<c:out value="${booking.customer.name}"/> 
<h3>Booking details. </h3><br>

 <div>
	<table border="1" bordercolor="blue" cellpadding="10" align="left" >
		<tr>
			<th>Book ID</th>
			<th>Vehicle Type</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Estimated Amount</th>
		</tr>

		 <c:forEach items="${bookings}" var="booking"> 
			<tr>
			
				<td><c:out value="${booking.b_id}"/></td>
				<td><c:out value="${booking.v_type}"/></td>
				<td><c:out value="${booking.s_date}"/></td>
				<td><c:out value="${booking.e_date}"/></td>
				<td><c:out value="${booking.e_amount}"></c:out>
			</tr>
			<tr>
			<th>Customer Email</th>
			<th>Customer Name</th>
			<th>Customer Address</th>
			<th>Customer Mobile No</th>
			</tr>
			<tr>
				<td><c:out value="${booking.customer.email}"></c:out></td>
				<td><c:out value="${booking.customer.name}"></c:out></td>
				<td><c:out value="${booking.customer.address}"></c:out></td>
				<td><c:out value="${booking.customer.mob}"></c:out></td>
			</tr>
			<tr>
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
				
				
			</tr>
			
		</c:forEach> 
	</table>
	<br>
	</div>
	<div>
	<c:url var="saveCustUrl" value="/service/finalbill" />
	<form:form modelAttribute="booking"  method="POST" action="${saveCustUrl}" >
	<table align="left" cellspacing="10">
	<form:hidden path="b_id" value="${booking.b_id}"></form:hidden>
	<tr><td><form:label path="s_kms">Starting Kms </form:label></td>
	<td><form:input path="s_kms" /></td><td><form:errors
				path="s_kms" /></td></tr>
	 
<tr><td><form:label path="e_kms">Ending Kms </form:label></td>
<td><form:input path="e_kms"/> </td><td><form:errors
				path="e_kms" /></td></tr>
				<tr><td><input type="submit" value="Bill" /></td></tr>
				</table>
				</form:form>
				</div>
</body>
</html>