<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Exam</title>
<script>
function submitExam(){
    //gets table
    var jsonObj=[];
    var i=2;
    var z=2;
    var j=2;
    $('input').each(
    	    function(index){  
    	        var input = $(this);
    	       // alert( input.val()+"  "+input.attr('type'));
    	        var arrJson={};
    	       
    	        
    	        if(input.attr('type')=='radio'){
    	        	if(j%2==0){
    	        	   var radioValue = $("input[name='radi"+i+"']:checked").val();
    	        	   //alert(radioValue)
    	        	   arrJson["QNO"]=z+"";
    	        	   arrJson["Ans"]=radioValue
    	        	   z=z+1;
    	        	   i=i+1;
    	        	}
    	        	
    	        	j++;
    	        }else{
    	        	j=0;
    	        	 arrJson["QNO"]=z+"";
    	        	//alert(input.val())
    	              arrJson["Ans"]=input.val()
    	              z=z+1;
    	        }
    	        jsonObj.push(arrJson)
    	        
    	    }
    	    
    	);
    var first = $("#first").val().toString()
    var second = $("#second").val().toString()
    var arrJson1={};
    arrJson1["QNO"]="20";
     arrJson1["Ans"]=first;
     jsonObj.push(arrJson1);
     var arrJson2={};
    arrJson1["QNO"]="21";
    arrJson1["Ans"]=second;
   jsonObj.push(arrJson2);
    
  // alert(JSON.stringify(jsonObj));
    $.post("insertAns.html",{jsonObj:JSON.stringify(jsonObj)},function(data){
    	alert(data)
    	if(data=='success'){
    		window.location="shome.html"
    	}
    })
}
</script>
</head>
<body>
<div style="height:280px;overflow:auto;">
${question}
</div>
</body>
</html>