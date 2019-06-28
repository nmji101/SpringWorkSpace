package kh.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Controller;

@Controller
@Aspect
public class PerfCheckAdvice {
	
	@Around("execution(* kh.spring.ao.MemberController.*(..))")
	public Object perfCheck(ProceedingJoinPoint pjp) {
		//ProceedingJoinPoint : 진행중인 join point //join point랑 같은역할을 한다.
		//다른점은, Around Advice들은 around 자신이 weaving된 method에 영향을 줄수있다.
		//before , after 는 자신이 할역할만 하고 끝이지만, Around는 변화를 줄수있다. 
		long startTime = System.currentTimeMillis();
		Object retVal = null;
		
		try {
			retVal = pjp.proceed();// pjp.proceed() 를 기점으로 이전이 before , 이후가 after
			//pjp.proceed();를 하는순간 해당 pointcut method가 실행된다.
			//pjp.proceed();의 리턴값은 pointcut method가 실행하고 난후의 리턴값. -> 현재 Controller에서는 String "home";
			//리턴이 String일수있고, ModelAndView 일수있고... 리턴값은 상황에따라 바뀌므로 Object로 받아준다.
		} catch (Throwable e) {
			//예외들의 조상 : Exception 인데 Exception의 상위클래스가있다. -> Throwable
			// Object(자바내의 모든클래스의 최고조상) -  Throwable - Exception
			e.printStackTrace();
		} 
		long endTime = System.currentTimeMillis();
		
		String methodName = pjp.getSignature().getName();
		System.out.println((endTime - startTime)/1000.0 + "초 동안 "+ methodName + " 작업수행");
		
		return retVal; 	//pointCut method가 작업을 끝내고 리턴한값을 Object retVal 받아준후, 
						//수행해야 할 작업을 수행한후에, 마지막에는 pointCut method의 리턴값을 보내줘야 한다.
	}
}
