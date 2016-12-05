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

<title>Final Bill</title>
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
<br>
<div>
<table border="1" cellpadding="10" align="left" >
		

		 <c:forEach items="${bookings}" var="booking"> 
			
			
			<tr><td><b>Book Id</b></td><td><c:out value="${booking.b_id}"/><br></td></tr>
			<tr><td><b>Customer Name</b></td><td><c:out value="${booking.customer.name}"/></td></tr>
			<tr><td><b>Amount Paid</b></td><td><c:out value="${booking.e_amount}"/></td></tr>
			<tr><td><b>Total Bill</b></td><td><c:out value="${booking.e_amount+booking.t_amount}"/></td></tr>
			<tr><td><b>Remaining amount to pay</b></td><td><c:out value="${booking.t_amount}"/></td></tr>
			</c:forEach> 
			</table>
		<br>
			<c:url var="saveCustUrl" value="/service/paid" />
		<form:form method="POST" action="${saveCustUrl}">
		<input type="submit" value="Pay"/>
		
		
		</form:form>
		</div>
</body>
</html>