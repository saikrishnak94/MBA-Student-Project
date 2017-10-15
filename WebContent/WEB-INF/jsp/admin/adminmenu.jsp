<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin menu</title>
<script type="text/javascript">
   function load(){
	   BootstrapDialog.show({
           message: $('<div></div>').load('remote.html')
       });
   }
</script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Student <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="regiform.html">Enter Student Details</a></li>
            <li><a href="editmail.html">Edit Email</a></li>
            <li><a href="editStudentConcen.html">Change Student Concentration</a></li>
			<li><a href="withdrawnprogram.html?type='withdraw'"> withdrawn from program</a>
			<li><a href="withdrawnprogram.html?type='accept'">accepted into program</a>
			<li><a href="withdrawnprogram.html?type='acceptcond'"> accepted into program with conditions</a>
			<li><a href="withdrawnprogram.html?type='approve'">approved for graduation</a>
			<li><a href="pullstudlist.html" title="Pull a list of students who have not completed the Academic Code of Conduct.">  Pull a list of students</a>
         
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Advisor <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="addAdvisor.html">Add Advisors</a></li>
            <li><a href="activeinactive.html">Make Advisor active or inactive</a></li>
            <li><a href="resetPassword.html">Reset Advisor Password</a></li>
			
          </ul>
        </li>
       
         <li><a href="addConcen.html">Add Concentrations</a></li>
         <li><a href="listConcentration.html">Edit Concentrations</a></li>
         <li><a class="dropdown-toggle" data-toggle="dropdown" href="#">program prerequisite<span class="caret"></span>
           
         </a>
           <ul class="dropdown-menu">
               <li><a href="addprerequisit.html">Add PreRequisit</a></li>
               <li><a href="editprerequisit.html">Edit Prerequisit</a></li>
           </ul>
         </li>
          <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">${User}
          <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="logout.html">Logout</a></li>
              </ul>
          </li>
      </ul>
       
     
    </div>
  </div>
</nav>
</body>
</html>