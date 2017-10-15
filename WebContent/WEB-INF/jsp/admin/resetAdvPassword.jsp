<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Email</title>
<script type="text/javascript">
  function resetPwd(){
	  $.post("resetPwd.html",{oldpwd:$("#oldpwd").val(),newpwd:$("#newpwd").val(),advid:$("#advid").val()},function(data){
		  alert(data)
		// window.location="adminHome1.html"
	  })
  }
  function validate(){
	  if($("#cpwd").val()==$("#newpwd").val()){
		  
	  }else{
		  alert("please enter both new and confirm password same")
	  }
  }
</script>
</head>
<body>
<form:form action="editEmail.html" commandName="registrationForm">
<table>
<tr>
<td>Advisor Id:</td>
<td><select id="advid">
   ${msg}
</select>
</td>
<tr>
<td>
  Old Password:
  </td>
  <td> <input type="password" id="oldpwd"></td>
  </tr>
  <tr>
  <td>New Password:</td>
  <td> <input type="password" id="newpwd"></td>
  </tr>
  <tr>
  <td>Confirm Password:</td>
  <td> <input type="password" id="cpwd" onblur="validate()"></td>
  </tr>
  <tr>
  <td colspan="2"><input type="button" value="Reset" onclick="resetPwd()"/></td>
  </tr>
</table>
</form:form>

</body>
</html>