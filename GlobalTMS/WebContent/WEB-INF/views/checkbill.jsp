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
<c:url var="saveCustUrl" value="/service/dobill" />
<form:form modelAttribute="booking"  method="POST" action="${saveCustUrl}" >
	<table align="left" cellspacing="10">
	<tr><td><form:label path="b_id">Bill No</form:label></td>
	<td><form:input path="b_id" /></td><td><form:errors
				path="b_id" /></td></tr>
				<tr><td><input type="submit" value="Check" /></td></tr>
				</table>
				</form:form>
</body>
</html>