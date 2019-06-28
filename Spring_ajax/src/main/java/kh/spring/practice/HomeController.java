package kh.spring.practice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kh.spring.dto.MessageDTO;

@Controller
public class HomeController {
	
	
//@RequestMapping(value = "/", method = RequestMethod.GET) //method = RequestMethod.GET get방식일때만 받아온다.
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@ResponseBody // @ResponseBody : 리턴값자체 그대로 전달해라. ajax통신할때 쓰는 어노테이션
	@RequestMapping(value="ajax.do" , produces="application/json;charset=UTF-8" )
	//produces="application/json;charset=UTF-8" 라고하면 json통신할때 한글이 깨지는것 방지한다.
	public String ajaxProc(HttpServletRequest request) {
		String text = request.getParameter("text");
		System.out.println("AJAX로 받은 값 : " + text);
		//ajax는 서버와 비동기 통신방식이므로 페이지전환이 일어나지않는다.
		//return "home"; //만약 이렇게 쓰면 home.jsp로 가게되고 , 그 값이 ajax의 결과로 전달된다. 즉 home.jsp의 소스코드가 전달된다
		//그래서 return값 String값 그자체를 response로 보내려면 @ResponseBody 어노테이션을 붙여준다.
		//return "ajax success";
		
		List<MessageDTO> list = new ArrayList<>();
		MessageDTO dto = new MessageDTO();
		for(int i=1; i<3; i++) {
			System.out.println(i);
			dto.setSeq(i);
			dto.setName("yhy"+i);
			dto.setMsg("hello"+i);
			list.add(dto);
		}
		System.out.println(list.get(0).getSeq());
		return new Gson().toJson(list);
	}
	
	
	
}
