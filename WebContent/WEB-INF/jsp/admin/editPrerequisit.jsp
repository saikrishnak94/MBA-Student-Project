<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
 function edit(var1,var2){
	 /* alert(var1+"   "+var2)
	 alert($("#"+var1).val())
	 alert($("#"+var1+"N").val()) */
	 $.post("editPrereq.html",{oldpid:var1,newpid:$("#"+var1).val(),
		 name:$("#"+var1+"N").val()},function(data){
			 alert(data)
		 })
 }
 function activate(i,pid){
	 $.post("activateInactivate.html",{status:i,pid:pid},function(data){
			 alert(data)
		 })
 }
</script>
</head>
<body>
${msg}
</body>
</html>