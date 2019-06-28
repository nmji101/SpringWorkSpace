package kh.websocket.chat;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session; //웹소켓 세션
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/chat",configurator=HttpSessionSetter.class) //spring 아님.
//configurator=HttpSessionSetter.class -> HttpSessionSetter에 설정된 handshake방식으로 EndpointConfig를 설정하겠다.
public class WebChat {
	//접속한 클라이언트들의 세션정보를 담을 컬렉션
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>()); //동기화 처리해주는 작업
	private static Map<Session,String> idList = new HashMap<Session,String>();
	
	@OnOpen
	public void onOpen(Session session,EndpointConfig ec) {
		HttpSession hSession = (HttpSession)ec.getUserProperties().get("httpSession");
		//실제 사이트에서 적용한다고 하면, 보통 session에서 id값을 담아줬을것이므로 이렇게 꺼내서 쓰면된다.
		String id = (String)hSession.getAttribute("id"); 
		System.out.println("id:"+id+" >>접속자발생");
		idList.put(session, id);
		clients.add(session); //연결되었을때, list에 담기
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("접속 종료");
		clients.remove(session);
		idList.remove(session);
	}
	
	@OnMessage
	public void onMessage(String message , Session session) throws Exception{ //메세지를 받으면,
		synchronized (clients) {//동시성 오류 발생을 잡기위해서 
			for(Session each : clients) {
				//String ip = (String) session.getUserProperties().get("javax.websocket.endpoint.remoteAddress");
				if(each != session) each.getBasicRemote().sendText(idList.get(session)+"님의메세지 : " + message);
			}
		}
	}
	
}
