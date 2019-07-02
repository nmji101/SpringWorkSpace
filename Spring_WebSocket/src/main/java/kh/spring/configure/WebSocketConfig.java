package kh.spring.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.StompWebSocketEndpointRegistration;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;


@Configuration //특정 옵션을 설정하기 위한 클래스들에 붙여주는 spring annotation. 기능은 component와 같다.
@EnableWebSocketMessageBroker //Spring WebSocket이용하기위해 추가해주기 1 : 스프링이 가동되면서 설정할내용들 // 웹소켓을 실행할때, 해당 클래스로 브로커역할을 한다고 인식한다.
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	//implements WebSocketMessageBrokerConfigurer -> Spring WebSocket이용하기위해 인터페이스 상속받기.
	
	//자바 버전 1.8이상으로 올라가면서 default method가 추가되었다.
	//인터페이스 안에 있는 method에 default가 붙게되면, 추상클래스의 일반메소드랑 같은 기능을하게된다. -> 강제적으로 method를 구현할필요는없다.
	
	//접근제한자 처럼보이지만 인터페이스안의 default는 구현할필요는 없는, 강제되지않는 인터페이스의 메소드라는 의미를 띄게된다.
	//default void methodName() {}; 이런식으로 추가되어있다.
	
	//WebSocketMessageBrokerConfigurer 상속받은후, configureMessageBroker 메소드 Override하기.
	//스프링 웹소켓이용하기위해 필수적으로 configureMessageBroker, registerStompEndpoints 이 두개의 메소드를 오버라이드 해줘야한다.
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app");
		//클라이언트가 /webchat 으로 연결해오면, 실제메세지를 보내는 url을 만들어서 사용한다.
		// 그때 url에 붙일 접두사를 설정해주는것이다.
		
		registry.enableSimpleBroker("/response");//클라이언트가 listen할 url. 메세지를 받았을때, 응답할 채널
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		StompWebSocketEndpointRegistration ser = registry.addEndpoint("/webchat"); //웹소켓연결하고싶으면 여기로 접속하면된다~ 라는뜻
		//클라이언트가 연결할때, /webchat이라는 연결포인트 endpoint를 만들어준다. 단지연결정보일뿐이다.
//		StompWebSocketEndpointRegistration ser1 = registry.addEndpoint("/stomp/webchat/info");
		//세션정보 공유할때, ser사용하게됨.
		//cross origin 허용  / 세션동기화 ...등을 설정해줄수있다.
		
		ser.setAllowedOrigins("*");//cross origin 허용
		
		//세션정보 공유
		ser.addInterceptors(new HttpSessionHandshakeInterceptor()/*어떤것을 가로챌것인지*/);	//stomp에서 세션정보를 가로채다.
		
		ser.withSockJS();
		
	}
}
