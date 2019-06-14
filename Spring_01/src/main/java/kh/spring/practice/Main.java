package kh.spring.practice;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kh.spring.impl.Friuts;
import kh.spring.impl.SamsungTv;
import kh.spring.interfaces.Tv;

public class Main {
	private static Tv SamsungTv;

	public static void main(String[] args) {
//		SamsungTv tv = new SamsungTv();
//		//프로젝트 규모가 작으면 스프링을 도입하는게 더 힘들수도있다 .
//		
//		//미래지향적 코드 ... -> 
//		//인터페이스로 기능을 강요해서..
//		
//		Tv tv1 = new LgTv();
//		//인터페이스를 씀으로써 프로그램의 확장성을 넓힌다.
//		//그런데 아직도 new 선언을 하고있는 코드다
//		//그래서 결합도를 낮추기위해 xml파일에서 미리 인스턴스를 만들어서 사용한다.
		
		//main실행했을때, spring을 가동시키기 위해 ...
		//이코드가 실행되면서 spring context가 실행된다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("context.xml");
		System.out.println("스프링 컨트롤러 만듦!");
		Tv tv = (SamsungTv)ctx.getBean("sam");
		Tv tv2 = ctx.getBean(SamsungTv.class); // 이런식으로 classType으로도 꺼낼수있다.
		Tv tv3 = ctx.getBean(Tv.class); //인터페이스도 부를수있다. 인터페이스를 꺼내오라고한다면
		//instance중에 Tv인터페이스를 상속받은 class를 가져와라 라는 의미이다.
		//만약에 instance pool 에 Tv인터페이스를 상속받은 class가 2개 이상이라면 에러난다
		//NoUniqueBeanDefinitionException: 
		//No qualifying bean of type 'kh.spring.interfaces.Tv' available: expected single matching bean but found 2: sam,lg
		
		tv.powerOn();
		tv2.powerOn();
		tv3.powerOn();
		//DL : 개발자가 스프링컨테이너 안의 bean을 가져다 쓸때
		//DI : 하나의 클래스를만들때, 그안에 member field에 다른 클래스를 넣어줘야할때 
		((SamsungTv)tv).getSpeaker().volumeUp();
		System.out.println("가격 기본값 : " + ((SamsungTv)ctx.getBean(Tv.class)).getPrice());
		((SamsungTv)ctx.getBean(Tv.class)).setPrice(5000);
		System.out.println("가격 수정값 : " + ((SamsungTv)ctx.getBean(Tv.class)).getPrice());
		
		
		Friuts f = (Friuts)ctx.getBean("friuts");
		System.out.println(f.getNamesList());
		System.out.println(f.getNamesSet());
		System.out.println(f.getNamesMap());
	}
}
