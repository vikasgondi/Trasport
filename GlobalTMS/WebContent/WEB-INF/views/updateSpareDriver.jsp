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
<c:url var="saveCustUrl" value="/admin/spare/update" />
<form:form modelAttribute="spareD"  method="POST" action="${saveCustUrl}" >
	<table align="left" cellspacing="10">
	
	<tr><td><form:label path="id">Driver Id </form:label></td>
	<td><form:input path="id" placeholder="${spareD.id}"/></td><td><form:errors
				path="id" /></td></tr>
	<tr><td><form:label path="email">Driver email </form:label></td>
	<td><form:input path="email" placeholder="${spareD.email}"/></td><td><form:errors
				path="email" /></td></tr>
				
	<tr><td><form:label path="name">Driver name </form:label></td>
	<td><form:input path="name" placeholder="${spareD.name}"/></td><td><form:errors
				path="name" /></td></tr>
	<tr><td><form:label path="v_no">Driver Vehicle No </form:label></td>
	<td><form:input path="v_no" placeholder="${spareD.v_no}"/></td><td><form:errors
				path="v_no" /></td></tr>
	<tr><td><form:label path="v_type">Vehicle Type</form:label></td>
	<td><form:input path="v_type" placeholder="${spareD.v_type}"/></td><td><form:errors
				path="v_type" /></td></tr>
	<tr><td><form:label path="mob">Mobile No </form:label></td>
	<td><form:input path="mob" placeholder="${spareD.mob}"/></td><td><form:errors
				path="mob" /></td></tr>
				<tr><td><input type="submit" value="Update" /></td></tr>
	</table>
	</form:form>
</body>
</html>