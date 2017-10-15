<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>addprerequisit</title>
</head>
<body>
<form:form method="post" action="addPrerequi.html" commandName="contact">

	<table class="loginTab">
	  <tr>
		<td><form:label path="UserId">PreRequist Num</form:label></td>
		<td><form:input path="userId" /></td> 
	</tr>
	<tr>
	<td colspan="2"><form:errors path="password" cssClass="errmsg"></form:errors></td>
	</tr>
	<tr>
		<td><form:label path="Password">Prereq Name</form:label></td>
		<td><form:input path="password" /></td>
	</tr>
	<tr>
	
	</tr>
	<tr>
	
		<td >
			<input type="submit" value="Add"/>
		</td>
		<td >
			<input type="reset" value="reset"/>
		</td>
	</tr>
</table>	
	
</form:form>
</body>
</html>