package kh.dependency.practice;

import kh.dependency.factory.TvFactory;
import kh.dependency.interfaces.Tv;
import kh.dependency.items.LgTV;

public class Main {
	public static void main(String[] args) {

		//		SamsungTV tv = new SamsungTV();
		//		tv.powerOn();
		//		tv.getModel();
		//		tv.getPrice();
		
		//처음에는 삼성TV 였다가 lgTV로 바뀔경우...

//		LgTV tv = new LgTV();
//		tv.turnOn();
//		tv.getModel();
//		tv.getPrice();
		
		//interface Tv만든후 LgTV의 powerOn() 하기
		Tv tv = new LgTV();
		tv.powerOn();
		
		//디자인 패턴중 팩토리 패턴
		//new 인스턴스 선언은 안하게되지만, tv brand가 변경된다면 코드수정이 필요하다.
		Tv tv1 = TvFactory.getInstane("lg");
		tv1.powerOn();
		
		//어떻게해야 코드수정까지 안할수있는지...???
		//만들고싶은 tv의 brand가 무엇인지 코드상에서 명시하면 안된다..? 
		//코드에 적는순간 이미 의존성이 생긴것이다. 
		
		//첫번째생각) 만들어야하는 tv의 종류를 main의 인자값으로 받아오자..
		//main의 매개변수 -> 실행시킬때넘기는 인자값.. 
		String selectedTvBrand = args[0];
		Tv tv2 = TvFactory.getInstane(selectedTvBrand);
		tv2.powerOn();
		//이 방법은 자세한 설정이 어렵다. samsungTv 까지 입력하는건되지만 , 볼륨을 높이고.. 이런 세부적인사항은 적용하기 어렵다.
		//그리고 만들고싶은 인스턴스가 여러개일경우... 
		
		//그래서 스프링프레임워크를 이용해 xml파일에 resource를 설정해서 불러온다.

		//여기까지는 java perspective 로 진행함
		
		// -> spring perspective 로 전환하기

	}
}
