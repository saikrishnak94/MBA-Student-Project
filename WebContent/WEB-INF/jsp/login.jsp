<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Login Form</title>
	<style>
    
   #logindiv{
   		/* background-image: url("images/images.jpg"); */
   		background-color:gray;
   		width:100%;
   		height:100%;
   		margin-top:-20px;
   		
   }.loginTab{
      margin-left:1px;
   }
   .errmsg{
      color:red;
      font-weight:bold;
   }
 </style>
</head>
<body>
<div id="logindiv">
<h2>Login</h2>
<form:form method="GET" action="addContact.html" commandName="contact">

	<table class="loginTab">
	<tr>
	  <td colspan="2"><form:errors path="userId" cssClass="errmsg"></form:errors></td>
	  </tr>
	  <tr>
		<td><form:label path="UserId">User ID</form:label></td>
		<td><form:input path="userId" /></td> 
	</tr>
	<tr>
	<td colspan="2"><form:errors path="password" cssClass="errmsg"></form:errors></td>
	</tr>
	<tr>
		<td><form:label path="Password">Password</form:label></td>
		<td><form:password path="password" /></td>
	</tr>
	<tr>
	
	</tr>
	<tr>
	
		<td >
			<input type="submit" value="Login"/>
		</td>
		<td >
			<input type="reset" value="reset"/>
		</td>
	</tr>
	<tr>
	  <td colspan="2" class="errmsg">${msg}</td>
	</tr>
</table>	
	
</form:form><br>
</div>
</body>
</html>
