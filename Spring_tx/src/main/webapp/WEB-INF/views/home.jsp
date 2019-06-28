<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
	<h1>쇼핑몰</h1>
	<form action="buy.service">
		상품id : <input type="text" name="pid" value="SL-2000"><br>
		상품이름 : <input type="text" name="pname" value="3G"><br>
		<input type="submit" value="buy">
	</form>
</body>
</html>