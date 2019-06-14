<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>입력받기</title>
<style>
	#container{
		width:200px;
		height : 300px;
		margin : auto;
	}
	input,button{
		font-size: 20px;
		margin-top : 10px;
	}
</style>
</head>
<body>
<div id="container">
	<h1>Input</h1>
	<form action="inputProc.do" method="post">
		<input type="text" name="name" placeholder="name"><br>
		<input type="text" name="message" placeholder="message"><br>
		<input type="submit" value="send">
		<button type="button" id="back">back</button>
	</form>
	</div>
	<script>
		document.getElementById("back").onclick = function () {
			location.href="/";
			//history.back(); //이전페이지로 돌려보내는 기능
		}
	</script>
</body>
</html>