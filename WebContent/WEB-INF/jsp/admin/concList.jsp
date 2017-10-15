<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ConcenTrations</title>
<script type="text/javascript">
$(document).ready(function(){
	 $("#resultTable").DataTable({
		 "scrollX":100,
		 "scrollY":100
	 
	 });
})
var degId='';
function storeId(id){
	degId=id
}
 function editConce(i){
	 
	 if(degId==''){
		 alert(degId);
		 degId=$("#DegreeCode"+i).val();
	 }
	 //alert(degId)
	$.post("editConcentration.html",{
		dCode:$("#DegreeCode"+i).val(),
		stat:$("#status"+i).val(),
		cName:$("#CName"+i).val(),
		advisor:$("#Advisor"+i).val(),
		DegreeCode:degId
	},function(data){
		alert(data)
	})
}
</script>
</head>
<body>
<div>
<h4><center>Edit Concentrations</center></h4>
<form action="" >
<table id="resultTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
<thead>
  <tr>
     <th>Code</th>
     <th>Status</th>
     <th>Course Name</th>
     <th>Advisor</th>
     <th>Edit</th>
  </tr>
  </thead>
  <tbody>
  <c:set var="i" value="1"></c:set>
<c:forEach var="list" items="${list}">
   <tr>
   
  <c:forEach var="map" items="${list}"> 
  <c:choose>
     <c:when test="${map.key=='DegreeCode'}">
        <td><input type="text" id="${map.key}${i}" value="${map.value}" onfocus="storeId('${map.value}')"/></td>
     </c:when>
     
     
     <c:when test="${map.key=='status'}">
   
     <td><select  id="${map.key}${i}">
       <c:choose>
     	<c:when test="${map.value=='active'}">
     	<option value="active" selected="selected"> active</option>
     	<option value="inactive"> inactive</option>
        </c:when>
        
        <c:otherwise>
        <option value="inactive" selected="selected">inactive</option>
        <option value="active"> active</option>
        </c:otherwise>
        </c:choose>
        </select></td>
     </c:when>
     
     
     
     <c:otherwise><td><input type="text" id="${map.key}${i}" value="${map.value}"/></td></c:otherwise>
     </c:choose>
  </c:forEach> 
  <td><input type="radio" name="rd"  onclick="editConce(${i})"/></td>
  <c:set var="i" value="${i+1}"></c:set>
  </tr>
</c:forEach>
</tbody>
</table>
</form>
</div>
</body>
</html>