<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" type="text/css" href="css/customerlogin1.css"/> -->
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>

  <script>
  $(document).ready(function() {
    $("#datepicker").datepicker();
  });
  $(document).ready(function() {
	    $("#datepicker1").datepicker();
	  });
  </script>
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
				<c:url var="saveCustUrl" value="/booking" />
					<form:form modelAttribute="booking"  method="POST" action="${saveCustUrl}" >
						<table align="left" cellspacing="10">
							<tr>
								<td>	<form:label path="v_type">Vehicle Type:</form:label></td>
								<td><form:select path="v_type">
									<form:option value="Indica">Indica</form:option>
									<form:option value="Innova">Innova</form:option>
									<form:option value="Scorpio">Scorpio</form:option>
									<form:option value="SwiftDesire">Swift Desire</form:option>
									<form:option value="Etios">Etios</form:option>
									<form:option value="TempoTraveller">Tempo Traveller</form:option>
									</form:select></td>
							</tr>	
							<tr>
								<td><form:label path="s_date">Starting date </form:label></td>
								<td><form:input path="s_date" id="datepicker"/></td><td><form:errors
									path="s_date" /></td>
							</tr>						 
							<tr>
								<td><form:label path="e_date">End Date </form:label></td>
								<td><form:input path="e_date" id="datepicker1"/> </td><td><form:errors
									path="e_date" /></td>
							</tr>						
							<tr>
								<td><form:label path="p_location">Pick Up Location</form:label></td>
								<td><form:input path="p_location"/></td>
							</tr>
							<tr>
								<td><input type="submit" value="Book" /></td>
							</tr>
						</table>
					</form:form>
					<br/>
		</div>

</body>
</html>