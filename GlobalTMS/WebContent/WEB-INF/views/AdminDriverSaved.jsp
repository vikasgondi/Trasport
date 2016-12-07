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
      <li ><a href="/GlobalTMS/admin/home">Home</a></li>
      <li class="active"><a class="dropdown-toggle" data-toggle="dropdown" href="/GlobalTMS/admin/driver">Driver<span class="caret"></span></a>
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
      
     
 <li><a href="/GlobalTMS/customer/listcustomer">Customer Detail</a></li>
      
     
      
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


<c:if test="${empty drivers}">
<h3>Driver Added Successful</h3>
<table border="1" cellpadding="10" align="left" style="border-color: blue;left; border-style: groove;text-decoration: blink;" >
		
		<%-- <c:forEach items="${bookings}" var="booking"> --%>
			<tr>
				<td>Driver Id</td>
				
				<td><c:out value="${driver.driver_id}"/></td>
				</tr>
			<tr>
				<td>Driver Name</td>
				<td><c:out value="${driver.d_name}"/></td>
			</tr>
			<tr>
					<td>Driver E mail</td>
				<td><c:out value="${driver.email}"/></td>
			</tr>
			<tr>
				<td>Vehicle No</td>
				<td><c:out value="${driver.vehicle_no}"/></td>
			</tr>
			<tr>	
					<td>Vehicle Name</td>
				<td><c:out value="${driver.vehicle_type}"></c:out></td>
			</tr>
			<tr>
					<td>Start Date</td>
				<td><c:out value="${driver.s_date}"></c:out></td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><c:out value="${driver.e_date}"></c:out></td>
			</tr>
	</table>		
		</c:if>
<c:if test="${!empty drivers}">
<h3>Driver Details</h3>
	<table border="1" cellpadding="10">
		<tr>
			<th>Driver Id</th>
			<th>Driver Name</th>
			<th>Driver email</th>
			<th>Vehicle No</th>
			<th>Vehicle Type</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>

		<c:forEach items="${drivers}" var="driver">
			<tr>
				<td><c:out value="${driver.driver_id}"/></td>
				<td><c:out value="${driver.d_name}"/></td>
				<td><c:out value="${driver.email}"/></td>
				<td><c:out value="${driver.vehicle_no}"/></td>
				<td><c:out value="${driver.vehicle_type}"></c:out></td>
				<td><c:out value="${driver.s_date}"></c:out></td>
				<td><c:out value="${driver.e_date}"></c:out></td>
				<c:url var="saveCustUrl" value="/admin/driver/${driver.driver_id}/update" />
				<c:url var="saveCustUrl1" value="/admin/driver/${driver.driver_id}/delete" />
				<td><button  onclick="location.href='${saveCustUrl}'">Update</button></td>
				<td><button  onclick="location.href='${saveCustUrl1}'">Delete</button></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
			
	<%-- 	</c:forEach> --%>
	</table>
</body>
</html>