<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home</title>
<script  src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style>
	input{
		font-size: 30px;
	}

</style>
<script>
	$(function(){
		$("#Logout").on("click",function(){
			location.href="logout";
		})
		$("#Login").on("click",function(){
			location.href="login?id=test";
		})
		$("#Mypage").on("click",function(){
			location.href="mypage";
		})
	})
</script>
</head>
<body>
	<input type="button" id="Login" value="Login">
	<input type="button" id="Mypage" value="Mypage">
	<input type="button" id="Logout" value="Logout">
</body>
</html>