package kh.spring.mybatis;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.PayDTO;
import kh.spring.service.BuyService;

@Controller
public class HomeController {
	
	@Autowired
	private BuyService buyService;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/")
	public String home() {
		session.setAttribute("id","tmpId");
		return "home";
	}
	
	@RequestMapping("buy.service")
	public String buyProcWithService(PayDTO dto) {
		String id = (String)session.getAttribute("id");
		try {
			buyService.buy(dto, id); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "home";
	}
	
	
}
