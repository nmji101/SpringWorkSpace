package kh.spring.ao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	//로그를 남기기위해서 aop를 사용하기전에는 메소드내에 직접 하나씩 코드를 추가해줘야한다.
	//1.
//	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss E요일");
	
	@RequestMapping("login")
	public String login(String id) {
//		System.out.println(sdf.format(System.currentTimeMillis())+"에 login 수행");
		return "home";
	}
	
	@RequestMapping("logout")
	public String logout() {
//		System.out.println(sdf.format(System.currentTimeMillis())+"에 logout 수행");
		return "home";
	}
	
	@RequestMapping("mypage")
	public String mypage() {
//		System.out.println(sdf.format(System.currentTimeMillis())+"에 mypage 수행");
		return "home";
	}
}
