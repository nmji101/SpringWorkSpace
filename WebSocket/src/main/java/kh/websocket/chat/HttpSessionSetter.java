package kh.websocket.chat;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class HttpSessionSetter extends ServerEndpointConfig.Configurator{
	//실시간 채팅할때, 해당정보를 얻어내서 넘겨주기위해 만들어준 클래스
	
//	 ServerEndpointConfig.Configurator:inner class
	
		@Override
		public void modifyHandshake(ServerEndpointConfig sec, 
				HandshakeRequest request,
				HandshakeResponse response) {
			//네트워크 장비들끼리 연결을 하기위해 서로 주고받는 정보들이 있다. 그 과정을 Handshake라고 부른다.
			//네트워크 연결이 성립할때, 여러 데이터를 주고받게된다. 
			//웹소켓은 Handshake과정을 거치게된다. 
			//클라이언트 -> 웹소켓 이었는데, 이 과정사이에 내가 원하는 작업을 추가해서 거쳐가게 하는 것이다.
			
			HttpSession hSession = (HttpSession)request.getHttpSession();
			System.out.println("임시출력:"+hSession.getAttribute("id"));
			sec.getUserProperties().put("httpSession", hSession);
			//-> 이 sec을 @OnOpen 메소드가 매개변수로 받아줄수있다. ->  WebChat
		}
}
