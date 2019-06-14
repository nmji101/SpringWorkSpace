<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인화면</title>
<style type="text/css">
* {
	font-size: 20px;
}
	#container{
		box-sizing: border-box;
		width : 300px;
		height:300px;
		margin : auto;
		text-align: center;
	}
	button{
		background-color: yellow;
		width: 100px;
		height : 50px;
	}
</style>
</head>
<body>
	<div id="container">
		<button id="toInput">Input</button>
		<button id="toOutput">Output</button>
	</div>
	
	<img alt="no img" src="/image/lion.png">
<!-- 	이미지 태그들은 src부분의 경로를 서버한테 요청한다.-->
	<script>
		document.getElementById("toInput").onclick = function(){
			location.href = "inputForm.do";
		}
		document.getElementById("toOutput").onclick = function(){
			location.href = "outputProc.do";
		}
	</script>
</body>
</html>