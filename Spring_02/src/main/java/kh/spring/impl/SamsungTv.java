package kh.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import kh.spring.interfaces.Speaker;
import kh.spring.interfaces.Tv;

@Component("sam") //Component(/*xml <bean id="sam"/> 에서 id역할 */)//annotation방식 
//Component : 나중에 스프링 컨테이너가 가동될때, 검색대상이  된다 
public class SamsungTv implements Tv{
	//@Autowired // @Autowired : 어노테이션 방식에서의 DI 사용법 -> 자동으로 연결시켜준다.
	//@Autowired 는 id명시 불가
	
	@Autowired
	@Qualifier("britz") //id명시할때는 , @Autowired @Qualifier("britz")같이 써줘야함. Qualifier는 Autowired 를 지원하는 기능이다.
	private Speaker speaker;
	
	public SamsungTv() {
		System.out.println("삼성TV 생성");
	}
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("삼성 Tv 켜짐");
		speaker.volumeUp();
	}
	
}
