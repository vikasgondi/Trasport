<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>
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
      <a class="navbar-brand" href="#">Admin</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/GlobalTMS/admin/home">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="/GlobalTMS/admin/driver">Driver<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/GlobalTMS/admin/driver/add">Add Driver</a></li>
          <li><a href="/GlobalTMS/admin/driver/list">Driver List</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="/GlobalTMS/admin/driver">Booking Detail<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/GlobalTMS/admin/booking/list">Booking List</a></li>
          <li><a href="/GlobalTMS/admin/booking/${1}">Booking by Booking Id</a></li>
          <li><a href="/GlobalTMS/admin/booking/${2}">Booking by Customer</a></li>
          <li><a href="/GlobalTMS/admin/booking/${3}">Booking by Driver</a></li>
          
        </ul>
      </li>
      <!-- <li><a href="/GlobalTMS/admin/Bdetails">Booking Detail</a></li> -->
      
     
 <li class="active"><a href="/GlobalTMS/admin/listcustomer">Customer Detail</a></li>
      
     
      
<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="/GlobalTMS/admin/spare">Spare Vehicle<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/GlobalTMS/admin/sparedriver/add">Add Vehicle</a></li>
          <li><a href="/GlobalTMS/admin/spare/list">Vehicle List</a></li>
          <li><a href="/GlobalTMS/admin/spare/allot">Allot Spare Vehicle</a></li>
        </ul>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/GlobalTMS/admin.logout"><span class="glyphicon glyphicon-user"></span> Log out</a></li>
          </ul>
  </div>
</nav>

<h2>Customer Details</h2>
<c:if test="${!empty customers}">
<table >

<tr>
			<th>Customer Email</th>
			<th>Customer Name</th>
			<th>Customer Address</th>
			<th>Customer Mobile No</th>
			</tr>

			<c:forEach items="${customers}" var="customer">
		
			<tr>
				<td><c:out value="${customer.email}"></c:out></td>
				<td><c:out value="${customer.name}"></c:out></td>
				<td><c:out value="${customer.address}"></c:out></td>
				<td><c:out value="${customer.mob}"></c:out></td>
			</tr>
		
	</c:forEach> 
	</table>
</c:if>

</body>
</html>