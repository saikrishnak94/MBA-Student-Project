<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Advisor Menu</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
         <li><a href="editPwd.html">Change Password</a></li>
         <li><a href="retrieveStudent.html?mode=view">Retrieve Student Profile</a></li>
         <li><a href="retrieveStudent.html?mode=review">Review Student Profile</a></li>
         <li><a href="markpreRequisit.html">Mark Prereqs Met</a></li>
         <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Notes&nbsp;&nbsp; &nbsp; &nbsp; 
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
          <li><a href="enterNote.html">Enter Notes</a></li>
           <li><a href="viewNote.html">Review previous Notes</a></li>
           </ul>
           </li>
          <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">${User}&nbsp;&nbsp;
          <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="logout.html">Logout </a></li>
              </ul>
          </li>
      </ul>
       
     
    </div>
  </div>
</nav>
</body>
</html>