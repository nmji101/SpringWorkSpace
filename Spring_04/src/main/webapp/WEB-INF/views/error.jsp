<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ERROR</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style>
*{
	font-size: 20px;
}
	div{
		width:200px;
		margin:auto;
	}
</style>
<script>
	$(function(){
		$("#toHome").on("click",function(){
			location.href="/";
		})
	})
</script>
</head>
<body>
	<div>
		Error <br><input id="toHome" type="button" value="home">
	</div>
</body>
</html>