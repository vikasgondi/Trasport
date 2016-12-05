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
      
     
 <li><a href="/GlobalTMS/admin/listcustomer">Customer Detail</a></li>
      
     
      
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

${mymsg}
<c:url var="saveCustUrl" value="/admin/driver/add" />
<form:form modelAttribute="driver"  method="POST" action="${saveCustUrl}" >
	<table align="left" cellspacing="10">
	
<tr><td>	<form:label path="d_name">Driver Name:</form:label></td>
	 <td><form:input path="d_name" /></td> <td><form:errors
				path="d_name" /></td></tr> 
	
<tr><td><form:label path="email">Driver Email </form:label></td>
	<td><form:input path="email" /></td><td><form:errors
				path="email" /></td></tr>
	 
<tr><td><form:label path="vehicle_no">Vehicle No </form:label></td>
<td><form:input path="vehicle_no"/> </td><td><form:errors
				path="vehicle_no" /></td></tr>
	
<tr><td>	<form:label path="vehicle_type">Vehicle Type:</form:label></td>
<td><form:select path="vehicle_type">
	<form:option value="Indica">Indica</form:option>
	<form:option value="Innova">Innova</form:option>
	<form:option value="Scorpio">Scorpio</form:option>
	<form:option value="Swift Desire">Swift Desire</form:option>
	<form:option value="Etios">Etios</form:option>
	<form:option value="Tempo Traveller">Tempo Traveller</form:option>
	</form:select></td></tr>
	<tr><td><form:label path="s_date">Starting date </form:label></td>
	<td><form:input path="s_date" /></td><td><form:errors
				path="s_date" />(mm/dd/yy)</td></tr>
				<tr><td><form:label path="e_date">End date </form:label></td>
	<td><form:input path="e_date" /></td><td><form:errors
				path="e_date" />(mm/dd/yy)</td></tr>

	

 
	<tr><td><input type="submit" value="Save" /></td></tr>
</table>
</form:form>

</body>
</html>