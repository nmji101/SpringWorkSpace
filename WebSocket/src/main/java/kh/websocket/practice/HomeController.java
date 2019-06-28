package kh.websocket.practice;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		return "home";
	}
	@RequestMapping("/webChat")
	public String webChat(String id) {
		System.out.println("id넘어오는지 확인:"+id);
		session.setAttribute("id", id);
		System.out.println("세션담은후 확인:"+session.getAttribute("id"));
		return "webChat";
	}
	
}
