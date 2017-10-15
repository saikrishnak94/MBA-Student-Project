<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add advisor</title>
</head>
<style>
.loginTab{
      margin-left:10px;
   }
   .errmsg{
      color:red;
      font-weight:bold;
   }
 </style>
</head>
<body>
<div id="logindiv">
<form:form method="POST" action="addAdvisor1.html" commandName="advisorForm">

	<table class="loginTab">
	<tr>
	  <td colspan="2"><h2>Add Advisor</h2></td>
	</tr>
	<tr>
	  <td colspan="2"><form:errors path="id" cssClass="errmsg"></form:errors></td>
	  </tr>
	  <tr>
		<td><form:label path="id">Advisor Id</form:label></td>
		<td><form:input path="id" /></td> 
	</tr>
	<tr>
	<td colspan="2"><form:errors path="name" cssClass="errmsg"></form:errors></td>
	</tr>
	<tr>
		<td><form:label path="name">Advisor Name</form:label></td>
		<td><form:input path="name" /></td>
	</tr>
	<tr>
	
		<td >
			<input type="submit" value="Add"/>
		</td>
		<td >
			<input type="reset" value="reset"/>
		</td>
	</tr>
	<tr>
	  <td colspan="2" class="errmsg">${msg}</td>
	</tr>
</table>	
	
</form:form>
</div>
</body>
</html>