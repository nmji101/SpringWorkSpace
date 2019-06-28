package kh.spring.aspect;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect//aop관련 advice로 spring이 인식하도록 하는 annotation
public class LogAdvices {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss E요일");
	
	//언제 끼워넣을건지 타이밍을 설정해야한다.
	//로그 기능은 일반적으로 before
	//aop 표현식 : return package... Controller..Method(..)
	
	@Before(/*aop표현식넣어주기*/"execution(* kh.spring.ao.MemberController.log*())") //execution(aop표현식)
	public void printLog() {
		System.out.println(sdf.format(System.currentTimeMillis())+"에 수행");
		System.out.println("MemberController에서 log로시작하는 method 중 매개변수가없는것에대해서 weaver");
		//전체 메소드에 이 기능을 사용하는것이아니라
		//몇몇 선택한 메소드들을 point하기위해서 -> aop 표현식

	}
	//aop표현식에 ..은 정규표현식에서 ? 와 같은의미이다. 있을수도있고 없을수도있다는뜻이다.
	@Before("execution(* kh.spring.ao.MemberController.*(String,..))") 
	public void param1() {
		System.out.println("parameter String,있을수도있고 없을수도있고");
	}
	@Before("execution(* kh.spring.ao.MemberController.*(..,..))") 
	public void param2() {
		System.out.println("parameter 1개일수도있고 , 2개일수도있고, 없을수도있고");
	}
	@Before("execution(* kh.spring.ao.MemberController.*())") 
	public void param3() {
		System.out.println("parameter 없을때");
	}
	@Before("execution(* kh.spring.ao.MemberController.*()) || execution(* kh.spring.ao.MemberController.*(String))") 
	public void or1() {
		System.out.println("or연산자로 이어서 연결할수도있다");
	}
	
	//pointcut 만들어서 weaver할시에 해당method명으로 쓸수있다.
	@Pointcut("execution(* kh.spring.ao.MemberController.*(..))")
	public void memberAll() {}
	
	@Pointcut("execution(* kh.spring.ao.HomeController.*())")
	public void homeAll() {}
	
//	@Before("memberAll() || homeAll()") 
//	public void pointCutUse() {
//		System.out.println("pointCut 어노테이션을 붙인후 그 method명을 weaver에 이용할수있다.");
//	}
	// ! -> not의 의미
//	@Before("!memberAll()") 
//	public void notMember() {
//		System.out.println("member컨트롤러 빼고 나머지 메소드");
//	}
	
	//weaver할시에 매개변수를 받을수..?
	@Before("memberAll()") 
	public void notMember(JoinPoint jp) {
		//해당 advice가 실행되기 직전에 JoinPoint에 정보를 담아서 넘겨줄수있다.
		//jp.getArgs();//advice가 실행될 pointcut의 매개변수를 받아온다.
		for(Object o : jp.getArgs()) {
			System.out.println("String : " + o);
		}
		System.out.println(Arrays.toString(jp.getArgs()));//배열을 스트링형태로 출력
		
		Signature sign = jp.getSignature();//현재실행되려고 하는 method의 정보값, import org.aspectj.lang.Signature;
		sign.getName();//device가 사용되는 method의 이름
		
		StringBuilder sb = new StringBuilder();
		sb.append(sdf.format(System.currentTimeMillis()) + "에");
		sb.append(sign.getName() + " 실행됨");
		System.out.println(sb.toString());
		System.out.println("어떤 클래스에 포함되어있는지 정보 -> " + jp.getTarget());
		System.out.println("해당method의 full 경로 : "+sign.toLongString());
		System.out.println("해당method의 간략한 경로 : "+sign.toShortString());
	}
	
	//로그인이 되었는지 모든 동작에대해서 확인하려고할때,..
	
	//성능측정
	//만약에, method마다 동작시간을 체크하고싶다면 before + after로 해결할수없다. 
	//왜냐하면 before는 해당method가 실행되기전에 시작하고 after는 실행완료후 시작하기때문에 정확한 시간이라고 볼수없다.
	//@Around는 해당method 시작! ----- 종료! 를 둘러싸는 어노테이션으로 이해하면된다.
	//@Around//overhead가 크기때문에, before로 할수있으면 before를 써서 최적화시켜야한다.
	//Advice들도 사용하는 기능별로 class를 따로 만드는 것이 좋다 -> PerfCheckAdvice로 이동해서 성능체크Advice만들기
	
}
