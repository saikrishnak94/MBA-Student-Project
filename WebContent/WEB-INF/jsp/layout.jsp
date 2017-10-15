<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
<div class="container">
		<div style="margin-left:-15px;"><tiles:insertAttribute name="header" /></div>
		<div style="margin-top:5px;float:left;width:21.5%;height:300px;border:1px solid pink;"><tiles:insertAttribute name="menu" /></div>
		<div style="background-image:url('images/image1.jpg');margin-top:5px;margin-left:5px;float:left;padding:10px;width:78%;height:300px;border:1px solid pink;overflow:auto">
		<tiles:insertAttribute name="body" /></div>
    	<div style="clear:both"><tiles:insertAttribute name="footer" /></div>
</div>
</body>
</html>
