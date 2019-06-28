<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메세지리스트</title>
<script  src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
	$(function(){
		$("#toHome").on("click",function(){
			location.href = "/";
		});
	})
</script>
<style>
	#wrapper{
		width:500px;
		margin:auto;
	}
</style>
</head>
<body>
	<div id="wrapper">
		<h1>메세지 목록</h1>
		<c:forEach var="list" items="${list }">
			<div> ${list.seq } -> ${list.name } : ${list.msg }</div>
		</c:forEach>
		<input type="button" value="home" id="toHome">
	</div>
</body>
</html>