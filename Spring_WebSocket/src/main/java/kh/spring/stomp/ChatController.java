package kh.spring.stomp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import kh.spring.dto.MessageDTO;

@Controller
public class ChatController {
	
//	http 프로토콜을 통해서 접속할때 -> RequestMapping
//	웹소켓 프로토콜을 통해서 접속 -> MessageMapping
	@MessageMapping("/chat")
	@SendTo("/response") // chat으로 맵핑되서 들어온 작업을 response 상태인 사람들에게 보내라.
	public MessageDTO messageProc(StompHeaderAccessor sha,MessageDTO dto) {
		//StompConfig에서 설정해둔 값을 가져올때이용.-> StompHeaderAccessor sha
		//여기서 session을 autowired를 해서 쓸수없다.적용불가
		//디스패처를 거쳐 넘어오는 request가 없기때문에 requset나 session에 대한 인지가 안된다.
		String id = (String)sha.getSessionAttributes().get("id");
//		dto.setName("ServertmpName");
		dto.setName(id);
		System.out.println("id -> "+id);
		System.out.println("클라이언트가 입력한 메세지 -> "+dto.getMessage());
		System.out.println("클라이언트 이름 -> "+ dto.getName());
		return dto; //pojo타입의 객체를 리턴하면 자동으로 멤버필드를 각 데이터를 json타입의 String으로 변환해 보내준다.(Jackson기능)
	}
}
