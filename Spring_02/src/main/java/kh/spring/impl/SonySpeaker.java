package kh.spring.impl;

import org.springframework.stereotype.Component;

import kh.spring.interfaces.Speaker;

@Component("sony")
public class SonySpeaker implements Speaker{

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("소니 : 볼륨업");
	}
	
}
