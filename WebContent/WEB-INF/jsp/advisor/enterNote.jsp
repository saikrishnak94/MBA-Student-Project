<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Note</title>
<script type="text/javascript">
function saveNote(){
	$.post("saveNote.html",{
		note:$("#note").val(),
		user:${User}
	},function(data){
		window.location="advisorHome.html";
	})
}
</script>
</head>
<body>
<h4>Enter Notes</h4>
<br><br>
Enter notes<br><textarea rows="6" cols="40" id="note"></textarea><br><br>
<button onclick="saveNote()">Save</button>
</body>
</html>