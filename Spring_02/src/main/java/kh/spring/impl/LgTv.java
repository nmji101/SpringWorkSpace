package kh.spring.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import kh.spring.interfaces.Speaker;
import kh.spring.interfaces.Tv;

@Component("lg")
public class LgTv implements Tv{
	
	@Resource(name="sony") // 해당 id를 명시해야 할경우에는 @Qualifier를 이용한다. 
	private Speaker speaker;
	
	public LgTv() {
		System.out.println("LGTV 생성");
	}
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("LG 티비 켜짐");
		speaker.volumeUp();
	}
	
}
