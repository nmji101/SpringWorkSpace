<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HOME</title>
<script  src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style>
	*{
		font-size: 30px;
	}
	#wrapper{
		width: 500px;
		margin: auto;
	}
</style>
</head>
<body>
	<form id="idForm" action="webChat" method="post">
	<div id="wrapper">
	<input type="text" id="id" name="id" placeholder="id입력">
	<input type="button" id="toChat" value="toChat">
	</div>
	</form>
	<script>
		$("#toChat").on("click",function(){
			if($("#id").val()==""){
				alert("id를 입력해주세요.");
				return;
			}
			$("#idForm").submit();
		})
	</script>
</body>
</html>