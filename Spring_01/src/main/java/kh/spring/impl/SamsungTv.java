package kh.spring.impl;//interface 구현한 class 패키지

import kh.spring.interfaces.Speaker;
import kh.spring.interfaces.Tv;

public class SamsungTv implements Tv{
//	private BritzSpeaker speaker;
	private Speaker speaker;
	private String model;
	private int price;
	private boolean power;
	
	
	public SamsungTv() {
		System.out.println("삼성티비 생성");
	}
	public SamsungTv(Speaker speaker, String model, int price, boolean power) {
		super();
		this.setSpeaker(speaker);
		this.model = model;
		this.price = price;
		this.power = power;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("삼성 티비 켜짐 : " + this);
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

}
