package kh.spring.impl;

import org.springframework.stereotype.Component;

import kh.spring.interfaces.Speaker;

@Component("britz")
public class BritzSpeaker implements Speaker {

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("브리츠  : 볼륨업");
	}

}
