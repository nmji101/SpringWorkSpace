<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mybatis</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style>
	*{
		font-family: sans-serif;
	}
	#wrapper{
		width:400px;
		font-size : 20px;
		margin: auto;
		text-align: center;
	}
	button{
		background-color: #fff847;
		font-size: 18px;
		border: 2px solid #ffd738;
		cursor:pointer;
		transition-duration: 0.5s;
		color: #43994a;
		padding: 5px;
	}
	button:hover {
		background-color: #56c44230;
		position: relative;
		top:-2px;
	}
	h1{
		color: #3a8740;
	}
	#tempDTO{
		position: relative;
		top: 15px;
	}
	#tempDTO:hover {
		top:13px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<h1>HOME</h1>
		<button id="insert">Insert</button>
		<button id="select">Select</button>
		<button id="selectOne">SelectOne</button>
		<button id="update">Update</button>
		<button id="delete">Delete</button>
		<button id="tempDTO">selectBytempDTO</button>
	</div>
	<script>
		$("button").on("click",function(){
			$(location).attr("href",$(this).attr("id"));
		});	
	</script>
</body>
</html>