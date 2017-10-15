<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Profile</title>
<script type="text/javascript">
  function studentProfile(){
	  alert($("#type").val())
	  if($("#studentId").val()!=''){
	  $.post("withdrawstudentProfile.html",{sid:$("#studentId").val(),type:$("#type").val()},function(data){
		  $("#sdata").html(data);
	  })
  }else{
	  alert("please select studentId")
  }
  }
  function withdrawn(type){
	  $.post("chnageStudentStatus.html",{sid:$("#studentId").val(),type:type},function(data){
		  alert(data+" "+type)
	  })
  }
</script>
</head>
<body>
<div style="float:left;margin-left:2%;">
<h3>Student Profile</h3>
<form>
  <select id="studentId" onchange="studentProfile()">
   ${msg}
  </select>
<input type="hidden" id="type" value=${type}>
</form>
<div id="sdata" style="float:left;margin-top:2%">
</div>
</div>
</body>
</html>