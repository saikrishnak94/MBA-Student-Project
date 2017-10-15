<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Menu</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/jquery-ui.css">
<script src="${pageContext.request.contextPath}/css/jquery-ui.js"></script>
  <script src="${pageContext.request.contextPath}/bootstrap/jquery-1.12.3.js"></script>
<style type="text/css">
  #student{
    background-color:#000010;
    height:100%;
  }
</style>
<script type="text/javascript">
    function cmptequet(){
    	$.post("completeQ.html",{},function(data){
    		$("#question").html(data)
    		alert(data)
    	})
    	$("#question").dialog({height:"auto",width:"auto"});
    }
</script>
</head>
<body>
<div id="student">
<br><br>
  <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
      <li><a href="completeQ.html">Complete Questionnaire</a></li>
      <li><a href="getCodeOfCoduct.html">Academic Code of Conduct</a></li>
       <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">${User}
          <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="logout.html">Logout</a></li>
              </ul>
          </li>
      </ul>
      </div>
      <div id="question" style="display:none"></div>
</div>
</body>
</html>