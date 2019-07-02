<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<script  src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style>
	div{
		width: 400px;
		margin: auto;
		text-align: center;
		font-size: 20px;
	}
	input{
		font-size: 20px;
		border: 1px solid skyblue;
		text-align: center;
		margin-bottom: 10px;
	}
</style>
</head>
<body>
	<div>
	<h1>Spring WebSocket</h1>
	<input id="id" type="text" placeholder="id입력" name="id"><br>
	<a href="chat" id="toChat">toChat</a>
	</div>
	<script>
	$("#id").keypress(function (e) {
        if (e.which == 13){
        	var id = $("#id").val();
        	if(id==""){
				alert("값을입력하세요.");
				return;
			}
        	$("#toChat").trigger("click");
        }
    });
	$("#toChat").on("click",function(){
		var id = $("#id").val();
    	if(id==""){
			alert("값을입력하세요.");
			return;
		}
	})
	</script>
</body>
</html>