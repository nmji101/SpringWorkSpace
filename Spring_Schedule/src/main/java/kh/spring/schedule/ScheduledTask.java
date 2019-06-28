package kh.spring.schedule;

import java.text.SimpleDateFormat;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//스케쥴링이 되는 메소드는 특정시간에 실행되는 메소드이기때문에 리턴값은 void / 매개변수는 받을수없다.
	@Scheduled(/*어떻게동작할건지조건*/fixedDelay=5000/*단위 milliSecond*/)
	public void task1() {
		System.out.println(sdf.format(System.currentTimeMillis())+" -> 1 출력확인");
	}
	//	fixedRate=5000 : 해당스케쥴링이 시간전에 끝나지않아도 멀티쓰레드처럼 다시 시작한다.
	//	fixedDelay=5000 : 해당스케쥴링이 정해준 시간전에 끝나지않다면 기다렸다가 시작한다.
	
	//시간을 표현하는 표현식 -> cron표현식 ==> 기본적으로 6자리로 이루어져있다. 초,분,시,일,월,요일,년도 순으로 나온다.
	//그런데 년도는 생략가능하고 일반적으로 생략한다. 그래서 6자리! (스케쥴링을 1년단위로 하는경우는 거의없기때문에)
	//시간은 기본적으로 24로 표현한다. 0시~23시
	//cron에 표기하는 시간은 절대적인 시간이다 . (cron="20 5 15 * * *") 라고 적으면 시간이  15시 5분 20초 가 될때마다.
	@Scheduled(cron="30 * * * * *")
	public void task2() {
		System.out.println(sdf.format(System.currentTimeMillis())+" -> 2 출력확인");
	}
	
	@Scheduled(cron="0 0 0 * * *")
	public void everyMidNight() {
		System.out.println(sdf.format(System.currentTimeMillis())+" -> 매일 자정에 출력 확인");
	}
	
	//1시 15분 30초 부터 매 7초마다 실행하려면 cron표현식으로 1시 15분 30초 를 적어준뒤 매 7초마다는 초에 / 슬래시를 붙이고 적어준다.
	@Scheduled(cron="30/7 15 13 * * *")
	public void task3() {
		System.out.println(sdf.format(System.currentTimeMillis())+" -> 1시 15분 30초 부터 매 7초마다 실행하려면 이렇게!");
	}
	//cron(cron="1,3,5 10-20 10 * * *") -> 10시 10~20분 1초,3초,5초 마다 실행해라. 
}
