package kh.spring.practice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dao.MessageDAO;
import kh.spring.dto.MessageDTO;

@Controller
public class HomeController {
	
	@Autowired
	private MessageDAO dao;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/inputForm")
	public String toInputForm() {
		return "inputForm";
	}
	
	@RequestMapping("/inputProc")
	public String inputProc(MessageDTO dto) {
		System.out.println(dto.getMsg() + " : " + dto.getName());
		int result=0;
		try {
			result = dao.insertMsg(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return "home";
	}
	
	@RequestMapping("/outputProc")
	public ModelAndView outputProc() {
		ModelAndView mav = new ModelAndView();
		List<MessageDTO> list = null;
		try {
			list = dao.selectAll();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.addObject("list", list);
		mav.setViewName("msgList");
		return mav;
	}

}
