<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Add Concentration</title>
	<%-- <style>
    
  .loginTab{
      margin-left:10px;
   }
   .errmsg{
      color:red;
      font-weight:bold;
   }
 </style> --%>
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

<form:form method="POST" action="addConcen1.html" commandName="concetration">

	<table class="loginTab">
	<tr>
	  <td colspan="2"><h2>Add Concentration</h2></td>
	</tr>
	<tr>
	  <td colspan="2"><form:errors path="dCode" cssClass="errmsg"></form:errors></td>
	  </tr>
	  <tr>
		<td><form:label path="dCode">Degree Code</form:label></td>
		<td><form:input path="dCode" /></td> 
	</tr>
	<tr>
	<td colspan="2"><form:errors path="cName" cssClass="errmsg"></form:errors></td>
	</tr>
	<tr>
		<td><form:label path="cName">Concentration Name</form:label></td>
		<td><form:input path="cName" /></td>
	</tr>
	<tr>
	   <td><form:label path="advisor">Advisor</form:label></td>
		<td><form:input path="advisor" /></td>
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
