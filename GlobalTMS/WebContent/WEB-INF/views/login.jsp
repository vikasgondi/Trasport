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
  
<link rel="stylesheet" type="text/css" href="css/customerlogin1.css"/>

<title>GTMS</title>

 </head>
 
<body >


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Welcome to book your cab service</a>
    </div>
        <ul class="nav navbar-nav navbar-right">
      <li><a href="/GlobalTMS/customer"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
          </ul>
  </div>
</nav>
   
<%-- <img src="css/image/Beautiful-Scene-HD-8.jpg" class="img-responsive" style="width:150%" alt="Image">
<jsp:include page="header.jsp"/>
 --%>
<div class="container"> 
    <div class="row vertical-offset-500">
    	<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			  	
${mymsg}

				<h1 class="panel-title"> Login </h1>
			 	</div>
			  	<div class="panel-body">
			    	
                    <fieldset>
				<c:url var="saveCustUrl" value="/login" />
					
					<form:form  modelAttribute="customer" method="POST" action="${saveCustUrl}">
						<%-- <form:label  path="email"><b>Email Id:</b></form:label> --%>
						
						<form:input  path="email" class="form-control" placeholder=" Enter your email"/><br/>
						<form:errors
				path="email" />
						<%-- <form:label path="password" ><b>Password</b></form:label> --%>
						
						<form:password path="password" class="form-control" placeholder="Password"/><br/>
						<form:errors
				path="password" />
						<input id="login-button" type="submit" class="btn btn-lg btn-success btn-block" value="Login" />
					</form:form>
					</fieldset>
	     </div>
			</div>
		</div>
	</div>
</div>


<!-- <div class="container text-center">
  <h3>.....</h3>
  <br>
  <div class="row">
    <div class="col-sm-3">
      <img src="css/image/images (1).jpg" class="img-responsive" style="width:100%" alt="Image">
      <p>Current Project</p>
    </div>
    <div class="col-sm-3">
      <img src="css/image/images.jpg" class="img-responsive" style="width:100%" alt="Image">
      <p>Project 2</p>
    </div>
    <div class="col-sm-3">
      <div class="well">
       <p>Some text..</p>
      </div>
      <div class="well">
       <p>Some text..</p>
      </div>
    </div>
    <div class="col-sm-3">
      <div class="well">
       <p>Some text..</p>
      </div>
      <div class="well">
       <p>Some text..</p>
      </div>
    </div>
  </div>
  <hr>
</div> -->
	
</body>



</html>