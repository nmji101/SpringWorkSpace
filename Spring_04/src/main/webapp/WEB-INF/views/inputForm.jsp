<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InputForm</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style>
	*{
		font-size: 20px;
	}
	#wrapper{
		width:400px;
		margin:auto;
		height:200px;
	}
</style>
<script>
	window.onload = function(){
		$("#btn").on("click",function(){
			var name = $("#name").val();
			var msg = $("#msg").val();
			alert(name + " : " + msg);
		});
	}
</script>
</head>
<body>
	<form action="inputProc" method="post">
		<div id="wrapper">
		<input id="name" type="text" name="name" placeholder="name"><br>
		<input id="msg" type="text" name="msg" placeholder="msg"><br>
		<input type="submit">
		<button id="btn" type="button">확인</button>
		</div>
	</form>
</body>
</html>