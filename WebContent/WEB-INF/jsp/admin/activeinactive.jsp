<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Activate or In activate advisor</title>
<script type="text/javascript">
   function changeStatus(id){
alert(id)
$.post("activateAdv.html",{id:id},function(data){
alert(data)
window.location="adminHome1.html";
})
   }
</script>
</head>
<body>
<div>
<h4><center>Activate/Inactivate Advisor</center></h4>
<form action="" >
<table id="resultTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
<thead>
  <tr>
     <th>Advisor Id</th>
     <th>Name</th>
     <th>Status</th>
     
  </tr>
  </thead>
  <tbody>
<c:set var="id" value=""></c:set>
<c:forEach var="list" items="${advisorlist}">
   <tr>
   
  <c:forEach var="map" items="${list}"> 
   <c:if test="${map.key=='advId'}">
      <c:set var="id" value="${map.value }"/>
   </c:if>
        
  <c:choose>
     <c:when test="${map.key=='status' }">
  <c:choose>
   <c:when test="${map.value=='active' }">
      <td><input type="button" id="status" onclick='changeStatus("${id}#inactive")' value="Inactivate"></td>
   </c:when>
    <c:otherwise>
      <td><input type="button" id="status" onclick='changeStatus("${id}#active")' value="Activate"></td>
    </c:otherwise>   </c:choose>
      </c:when>
      <c:otherwise>
        <td><input type="text" id="${map.key}" value="${map.value}"/></td>
      </c:otherwise>
      </c:choose>
  </c:forEach> 
  </tr>
</c:forEach>
</tbody>
</table>
</form>
</div>
</body>
</html>