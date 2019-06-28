<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home</title>
<script  src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
	<input type="text" id="val">
	<script>
		$("#val").on("input",function(){
			$.ajax({
				url:"ajax.do",
				dataType:"json",
// 				error : function(){
// 					deflecated 문법 : 사라질수있는... 앞으로는 안쓰는? fail(function(){}) 이 최신제공기능
// 				}
				data:{text : $("#val").val() }
			}).done(function(resp){
				//console.log(resp);
// 				var result = JSON.parse(resp); -> dataType:"json"대신에 이렇게 parse해도 된다.
				console.log(resp[0].name);
			}).fail(function(resp){
				//서버가 ajax처리를 하다가 throws Exception 했을때(500 internal error) ,
				//혹은 서버와의 통신이 실패했을때... 잘못된 url로 통신했거나..
				//이쪽으로 실행된다.
				console.log(resp);
			});
		});
	</script>
</body>
</html>