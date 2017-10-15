<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
       <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Student Concentrations</title>
<script type="text/javascript">
function editContration(){
	alert()
      $.post("editContration.html",{studId:$("#studentId").val()},
    		  function(data){
    	  $("#stdconc").html(data)
    	  
      })
}
function changeConcen(){
	var concen = $("#concen").val()
	var concenStr = concen.toString();
	alert(concenStr)
	$.post("changeContration.html",{studId:$("#studentId").val(),concen:concenStr},
    		  function(data){
    	  alert(data)
    	  
      })
}
</script>
</head>
<body>
<select id="studentId" onchange="editContration()">
${msg}
</select>
<div id="stdconc" style="width:30%;">
</div>
</body>
</html>