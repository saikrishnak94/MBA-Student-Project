<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<style>
    
   .regTab{
   		background-image: url("images/images.jpg" 400px 850px);
   }
   .errmsg{
     color:red;
   }
 </style>
 <script type="text/javascript">
   $(document).ready(function(){
	   $.post("getConcetration.html",{},function(data){
		   $("#concen").html(data);
	   })
   })
 </script>
</head>
<body>
<h3>Student Details</h3>
<form:form method="post" action="addStudent.html" commandName="registrationForm">
<div  class="regTab">
  <div style="float:left">
        <table>
	<tr>
		<td><form:label path="fName">First Name</form:label></td>
		<td><form:input path="fName" /></td> <td><form:errors path="fName" cssClass="errmsg"/></td> 
	</tr>
	<tr>
		<td><form:label path="lName">Last Name</form:label></td>
		<td><form:input path="lName" /></td><td><form:errors path="lName" cssClass="errmsg"/></td>
	</tr>
	<tr>
		<td><form:label path="sID">Student ID</form:label></td>
		<td><form:input path="sID" /></td><td><form:errors path="sID" cssClass="errmsg"/></td>
	</tr>
	<tr>
		<td><form:label path="uemail">UCMO Email</form:label></td>
		<td><form:input path="uemail" /></td>
	</tr>
	<tr>
		<td><form:label path="perEmail">Personal Email</form:label></td>
		<td><form:input path="perEmail" /></td>
	</tr>
	<tr>
		<td><form:label path="phoneNo">Phone number</form:label></td>
		<td><form:input path="phoneNo" /></td>
	</tr>

	<tr>
		<td><form:label path="mailingAddr">Mailing Address</form:label></td>
		<td><form:textarea path="mailingAddr" rows="5" cols="20" /></td>
	</tr>

	
	</table>
  </div>
  <div style="float:left">
    <table style="float:left;margin-left:2px;">
	<tr>
		<td><form:label path="entrydate">Program entry date(YYYY-MM-DD)</form:label></td>
		<td><form:input path="entrydate" /></td>
	</tr>
	
	<tr>
		<td><form:label path="verbal">Verbal</form:label></td>
		<td><form:input path="verbal" /></td>
		</tr>
		<tr>
		<td><form:label path="quantitative">Quantitative</form:label></td>
		<td><form:input path="quantitative" /></td>
		</tr>
		<tr>
		<td><form:label path="gpa">GPA</form:label></td>
		<td><form:input path="gpa" /></td>
		</tr>
		<tr>
		<td><form:label path="concentrations">Concentration</form:label></td>
		<td><form:select path="concentrations" id="concen" multiple="false">
		    <form:option value="select"></form:option>
		     <form:option value="select"></form:option>
		      <form:option value="select"></form:option>
		      </form:select>
		</td>
	</tr>
		<tr>
		<td colspan="10">
			<input type="submit" value="Register"/>
		</td>
	</tr>
</table>	
  </div>
</div>
	
	
	
</form:form>
</body>
</html>