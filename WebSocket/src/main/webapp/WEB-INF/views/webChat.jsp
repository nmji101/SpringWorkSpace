<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WebChat</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style>
	div{
		border: 1px solid black;
		box-sizing: border-box;
	}
	#header{
		width: 400px;
		margin: auto;
		text-align: center;
	}
	#wrapper{
		width: 400px;
		height : 500px;
		margin: auto;
		font-size: 30px;
	}
	.contents{
		width: 100%;
		height: 80%;
		overflow-y: scroll;
		font-size: 15px;
	}
	.control{
		width: 100%;
		height: 20%;
		overflow:hidden;
	}
	.control>input[type='text']{
		width: 75%;
		height: 100%;
		box-sizing: border-box;
		-moz-box-sizing: border-box;
		-webkit-box-sizing: border-box;
	}
	.control>input[type="button"]{
		width: 20%;
		height: 100%;
		box-sizing: border-box;
		-moz-box-sizing: border-box;
		-webkit-box-sizing: border-box;
	}
	.myWrap{
		text-align: right;
		border: none;
		margin-top : 3px;
	}
	.my{
		background-color: skyblue;
	}
	.otherWrap{
		border: none;
		margin-top : 3px;
	}
	.other{
		background-color: pink;
	}
	#send{
		border: none;
		background-color: #ffd0c4;
		cursor: pointer;
		font-size: 20px;
		transition-duration:0.5s;
		font-family: sans-serif;
	}
	#send:hover {
		background-color: #ffd0c4;
		opacity: 0.6;
	}
</style>
</head>
<body>
	<div id="header"><H1>WebChat</H1></div>
	<div id="wrapper">
		<div id="contents" class="contents">
		
		</div>
		<div class="control">
			<input id="input" type="text">
			<input id="send" type="button" value="보내기">
		</div>
	</div>
	<script>
		//ip를 적어두고, 내가 test해볼때에 localhost로 입력하고 접속하면 적용이안된다.
		//아마 sop 이슈인거같다고 하심 . 
		var socket = new WebSocket("ws://192.168.60.22/chat");
		//new WebSocket(통신하고자 하는 대상의 위치를 적어준다.);
		
		socket.onmessage = function(evt){//서버로 부터 메시지가 도착했을때,
			//.contents 에 받은메세지를 넣어준다.
			$(".contents").append($("<div class='otherWrap'><span class='other'>"+evt.data+"</span></div>"));
			var objDiv = document.getElementById("contents");
			objDiv.scrollTop = objDiv.scrollHeight;
		}
		$("#send").on("click",function(){
			var msg = $("#input").val();
			$("#input").val("");
			$(".contents").append($("<div class='myWrap'><span class='my'>나의메세지 : "+msg+"</span></div>"));
			socket.send(msg);
			var objDiv = document.getElementById("contents");
			objDiv.scrollTop = objDiv.scrollHeight;
		});
		$("#input").keypress(function (e) {
	        if (e.which == 13){
	        	var msg = $("#input").val();
	        	if(msg==""){
	        		alert("메세지를 입력해주세요.");
	        		return;
	        	}
				$("#input").val("");
				$(".contents").append($("<div class='myWrap'><span class='my'>나의메세지 : "+msg+"</span></div>"));
				socket.send(msg);
				var objDiv = document.getElementById("contents");
				objDiv.scrollTop = objDiv.scrollHeight;
	        }
	    });
	</script>
</body>
</html>