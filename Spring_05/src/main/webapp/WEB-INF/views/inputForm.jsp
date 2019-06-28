<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InputForm</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
	<form action="inputProc" method="post">
		<h2>입력하기</h2>
		<input type="text" name="name" placeholder="name"><br> 
		<input type="text" name="msg" placeholder="msg"><br> 
			<input type="submit">
	</form>
</body>
</html>