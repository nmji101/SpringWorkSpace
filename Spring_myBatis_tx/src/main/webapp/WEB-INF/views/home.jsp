<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<script  src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style>
	#wrapper{
		width: 400px;
		margin: auto;
		text-align: center;
		margin-top: 50px;
	}
	input{
		font-size: 20px;
	}
	#wrapper div{
		margin-top: 10px;
	}
	#buyBtn{
		background-color: #fff847;
		border: 2px solid #ffd738;
		cursor:pointer;
		transition-duration: 0.5s;
		color: #43994a;
		padding: 5px;
	}
</style>
</head>
<body>
	<div id="wrapper">
		<form action="buy.service">
		<div>모델명 : <input type="text" name="pid" value="SL-2000"></div>
		<div>상품명 : <input type="text" name="pname" value="3G"></div>
		<div><input id="buyBtn" type="submit" value="buy"></div>
		</form>
	</div>
</body>
</html>