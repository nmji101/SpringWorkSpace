<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>입력한 목록 보기</title>
<style>
* {
	font-size: 20px;
}

#container {
	width: 500px;
	margin: auto;
}
#container>#toIndex{
	font-size: 25px;
}
</style>
</head>
<body>
	<div id="container">
		<c:forEach var="list" items="${list }">
			<div>${list.seq}번글->${list.name } : ${list.msg }</div>
		</c:forEach>
		<input id="toIndex" type="button" value="back">
	</div>
	<script>
		document.getElementById("toIndex").onclick=function(){
			location.href="/";
		}
	</script>
</body>
</html>