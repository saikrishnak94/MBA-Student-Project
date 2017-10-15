<!DOCTYPE html>
<html lang="en">
<%@include file="taglib.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
  <title>MBA Header</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 <style>
    .headerpart {
    background-image: url("images/index.jpg");
    background-repeat: repeat-x;
}
 </style>
</head>
<body>
<div class="container">
<div class="headerpart">
<table >
<tr>
<td><img alt="" src="images/UCM logo.jpg" height="100px;"></td>
<td></td>
<td style="padding-left:20px;"><h1>Master of BUSINESS ADMINISTRATION</h1></td>
</tr>
</table>
</div>
  <%-- <div class="row">
    <div class="col-sm-4">
      <h3>Login</h3>
      <hr/>
      <form:form action="login">
      User:
      </form:form>
    </div>
    <div class="col-sm-4">
      <h3>Column 2</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
    <div class="col-sm-4">
      <h3>Column 3</h3>        
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
  </div> --%>
</div>

</body>
</html>