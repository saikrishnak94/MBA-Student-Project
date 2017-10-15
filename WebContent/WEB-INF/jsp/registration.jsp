<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<form:form method="post" action="addContact.html">

	<table class="loginTab">
	<tr>
		<td><form:label path="UserId">User ID</form:label></td>
		<td><form:input path="userId" /></td> 
	</tr>
	<tr>
		<td><form:label path="Password">Password</form:label></td>
		<td><form:password path="password" /></td>
	</tr>
	
	<tr>
		<td colspan="2">
			<input type="submit" value="Login"/>
		</td>
	</tr>
</table>	
	
</form:form>
</body>
</html>