<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Email</title>
</head>
<body>
<form:form action="editEmail.html" commandName="registrationForm">
<table>
<tr><td colspan="2"><h3>${msg}</h3></td></tr>
<tr>
<td>
  <form:label path="sID">Student Id:</form:label>
  </td>
  <td> <form:input path="sID"/></td>
  
  </tr>
  <tr>
  <td><form:label path="perEmail">Email:</form:label></td><td> <form:input path="perEmail"/></td>
  </tr>
  
  <tr>
  <td><form:label path="uemail">UCM Email:</form:label></td><td> <form:input path="uemail"/></td>
  </tr>
  <tr>
  <td colspan="2"><input type="submit" value="Edit"/></td>
  </tr>
</table>
</form:form>

</body>
</html>