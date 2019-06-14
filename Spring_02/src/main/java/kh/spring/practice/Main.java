package kh.spring.practice;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kh.spring.impl.LgTv;
import kh.spring.impl.SamsungTv;
import kh.spring.interfaces.Tv;

public class Main {
	public static void main(String[] args) {
		//annotation방식 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("context.xml");
		Tv tv =(Tv)ctx.getBean("sam");
		tv.powerOn();		
		
		tv = (Tv)ctx.getBean("lg");
		tv.powerOn();
	}
}
