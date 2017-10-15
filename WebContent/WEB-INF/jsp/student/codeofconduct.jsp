<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Code of conduct</title>
<script type="text/javascript">
 function codeOfconduct(){
	 $.get("codeofConduct.html",{},function(data){
		 alert(data)
	 })
 }
</script>
</head>
<body>
<p>The students are expected to contribute a dynamic and inspiring academic environment and thus contribute to fostering a good learning process by demonstrating a high level of ambition and assuming co-responsibility for teaching, learning, group 
assignments and projects. Students must be aware that the consequences of violating standards of academic honesty are extremely serious that may result in the loss of career opportunities.

In all learning situations, the school values a friendly and welcoming atmosphere between and among students and staff.

</p>
<input type="checkbox" id="code"/>I agree above terms and conditions.
<br><button onclick="codeOfconduct()">Ok</button>
</body>
</html>