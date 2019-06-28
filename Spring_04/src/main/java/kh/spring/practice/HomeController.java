package kh.spring.practice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dao.MessageDAO;
import kh.spring.dto.MessageDTO;

@Controller //annotation을 붙이면 , xml bean에 instance가 만들어지는데, Controller 어노테이션이 붙으면 handler mapper로 인식한다.
public class HomeController {
	//pojo를 지킬수있게, 어노테이션방식으로 컨트롤러 만든다.
	//@Controller 를 붙이면 implements Controller 가 없어도 handler mapper로 동작가능하다
	
	//세션을 이렇게 만들어두면, session에 저장하고싶을때 불러다 쓰면된다.
	@Autowired
	private HttpSession session;
	
	@Autowired
	private MessageDAO dao;
	
	@RequestMapping("/")  //@RequestMapping("/") : url패턴 / 에대해서 아래 method를 실행해라 url하나당 method 하나를  매칭(맵핑)시킬수있다. 
	public String index() {
		//return값은 어떤 jsp로 갈건지
		//return "WEB-INF/views/home.jsp"; //forward방식으로 전달한다.
		
		return "home";
		//return하는 페이지의 이름이 바뀔경우, 손쉽게 변경하기위해서 view resolver를 이용한다.
		//페이지 경로설정을 편하게 해주는 장점이 있다. 단, view resolver는 필수가 아니고 선택사항이다. 
	}
	
	@RequestMapping("/inputForm")
	public String toInputForm() {
		return "inputForm";
	}
	
//	@RequestMapping("/inputProc")
//	public String inputProc(HttpServletRequest request) {
//		//스프링에서는 내가 원하는것을 써놓으면 알아서 담아온다
//		try {
//			request.setCharacterEncoding("utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String name = request.getParameter("name");
//		String msg = request.getParameter("msg");
//		System.out.println(name + " : " + msg);
//		return "home";
//	}
	
//	@RequestMapping("/inputProc")
//	public String inputProc(String name,String msg) {
//		//이렇게 쓰면 request.getParameter() 할필요없다.
//		//만약 넘겨받는 정보가 dto라면 , dto에 setter가 있다는 가정하에 
//		//spring이 자동으로 dto의 member field에 set해서 넘겨받아준다.
//		System.out.println(name +  " : " + msg);
//		
//		return "home";
//	}
	
	@RequestMapping("/inputProc")
	public String inputProc(MessageDTO dto) {
		//만약 넘겨받는 정보가 dto라면 , dto에 setter가 있다는 가정하에 
		//spring이 자동으로 dto의 member field에 set해서 넘겨받아준다.
		System.out.println(dto.getSeq() + "-> 이름 : " + dto.getName() +  " , 메세지: " + dto.getMsg());
		int result = 0;
		try {
			result = dao.insertMsg(dto);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		System.out.println(result);
		return "home";
	}
	
	@RequestMapping("/OutputProc")
	public String outputProc(HttpServletRequest request) {
		List<MessageDTO> list = null;
		try {
			list = dao.selectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		System.out.println(list.size());
		request.setAttribute("list", list);
		return "showList";
	}
}
