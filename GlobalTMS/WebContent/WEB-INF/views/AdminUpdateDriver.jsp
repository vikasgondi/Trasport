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
<c:url var="saveCustUrl" value="/admin/driver/update" />
<form:form modelAttribute="driver"  method="POST" action="${saveCustUrl}" >
	<table align="left" cellspacing="10">
		<form:hidden path="driver_id" value="${driver.driver_id}" />
<tr><td>	<form:label path="d_name">Driver Name:</form:label></td>
	 <td><form:input path="d_name" placeholder="${driver.d_name}"/></td> <td><form:errors
				path="d_name" /></td></tr> 
	
<tr><td><form:label path="email">Driver Email </form:label></td>
	<td><form:input path="email" placeholder="${driver.email}"/></td><td><form:errors
				path="email" /></td></tr>
	 
<tr><td><form:label path="vehicle_no">Vehicle No </form:label></td>
<td><form:input path="vehicle_no" placeholder="${driver.vehicle_no}"/> </td><td><form:errors
				path="vehicle_no" /></td></tr>
	
<tr><td>	<form:label path="vehicle_type" placeholder="${driver.vehicle_type}">Vehicle Type:</form:label></td>
<td><form:select path="vehicle_type">
	<form:option value="Indica">Indica</form:option>
	<form:option value="Innova">Innova</form:option>
	<form:option value="Scorpio">Scorpio</form:option>
	<form:option value="Swift Desire">Swift Desire</form:option>
	<form:option value="Etios">Etios</form:option>
	<form:option value="Tempo Traveller">Tempo Traveller</form:option>
	</form:select></td></tr>
	<tr><td><form:label path="s_date">Starting date </form:label></td>
	<td><form:input path="s_date" placeholder="${driver.s_date}" /></td><td><form:errors
				path="s_date" />(mm/dd/yy)</td></tr>
				<tr><td><form:label path="e_date">End date </form:label></td>
	<td><form:input path="e_date" placeholder="${driver.e_date}" /></td><td><form:errors
				path="e_date" />(mm/dd/yy)</td></tr>

	

 
	<tr><td><input type="submit" value="Update" /></td></tr>
</table>
</form:form>
</body>
</html>