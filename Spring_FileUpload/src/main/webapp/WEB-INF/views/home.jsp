<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style>
* {
	font-size: 30px;
}

#wrapper {
	width: 400px;
	margin: auto;
	overflow: hidden;
}
input{
	margin-top :10px;
}
</style>
</head>
<body>
<!-- get방식은 header에 정보를 붙여 보내는것이고, post방식은 body에 정보를 담아 보내는방식 -->
<!-- file은 binary  -->
	<div id="wrapper">
		<form action="upload.commons" method="post" enctype="multipart/form-data">
			<input type="text" name="name"><br> 
			<input type="file" name="image"><br>
			<input type="submit" value="send">
		</form>
	</div>
</body>
</html>