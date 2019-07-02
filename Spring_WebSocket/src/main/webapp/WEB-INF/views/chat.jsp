<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chatting</title>
<script  src="https://code.jquery.com/jquery-3.4.1.js"></script>
<!-- socketjs.js cdn -->
<script src ="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
<!--  stomp.js cdn-->
<script src ="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<style>
	.input{
		width: 400px;
		margin: auto;
		text-align: center;
		font-size: 30px;
	}
	.contents{
		width: 400px;
		margin: auto;
		margin-top: 50px;
		height: 500px;
		overflow: auto;
		font-size: 20px;
	}
	#message{
		font-size: 30px;
		border: 1px solid skyblue;
		width: 200px;
	}
	#send{
		border: 1px solid skyblue;
		background-color: #f7f7b2;
		font-size: 30px;
		cursor: pointer;
		color : skyblue;
		transition-duration:0.5s;
	}
	#send:hover{
		background-color: #8fe9f750;
	}
</style>
</head>
<body>
	<div class="contents">
		
	</div>
	<div class="input">
		<input type="text" id="message"><button id="send">send</button>
	</div>
	<script>
		//웹소켓사용하기위해 CDN필요하다.
		//1. socketjs.js cdn 검색후, 
		//https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js 
		//
		//var socket = new WebSocket(); -> 접속하는 브라우저가 WebSocket()객체를 만드는데 문제가 없다면 이렇게 써도되고, socketjs.js cdn도 필요없다.
		//하지만 접속하는 브라우저의 종류를 모를때에는 socketjs.js cdn 도 추가해주고 아래와같이 해야한다. 
		var socket = new SockJS("/stomp/webchat"); //endPoint를 넣어준다.
		var client = Stomp.over(socket); //연결작업에 대한 지원..?
// 		client.connect({헤더정보인데, 보통 비어있는상태로 보낸다},)		
		client.connect({},function(resp){
			console.log(resp);
			client.subscribe("/response",function(serverMsg){
				console.log("serverMsg");
				console.log(serverMsg);
				console.log("serverMsg.body");
				console.log(serverMsg.body);
				var result = JSON.parse(serverMsg.body);
				
				console.log(result.name + " : " + result.message);
				
				var line = $("<div></div");
				line.append(result.name + " : " + result.message);
				$(".contents").append(line);
				var objDiv = $(".contents");
				objDiv.scrollTop(objDiv.prop("scrollHeight"));
			});
		});		
		$("#send").on("click",function(){
			var msg = $("#message").val();
			if(msg==""){
				alert("값을입력하세요.");
				return;
			}
			$("#message").val("");
			//client.send("") 세번째인자값 : 보내려는 데이터
			client.send("/app/chat",{},JSON.stringify({message:msg}));
			//이렇게 값을 넘기면 Jackson이 동적바인딩해준다
		});
		$("#message").keypress(function (e) {
	        if (e.which == 13){
	        	var msg = $("#message").val();
	        	if(msg==""){
					alert("값을입력하세요.");
					return;
				}
				$("#message").val("");
				client.send("/app/chat",{},JSON.stringify({message:msg}));
	        }
	    });
	</script>
</body>
</html>