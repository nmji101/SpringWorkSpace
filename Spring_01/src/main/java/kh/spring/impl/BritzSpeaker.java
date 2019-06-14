package kh.spring.impl;

import kh.spring.interfaces.Speaker;

public class BritzSpeaker implements Speaker{
	public void volumeUp() {
		System.out.println("브리츠: 볼륨업");
	};
}
