package kh.spring.practice;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kh.spring.dao.MessageDAO;
import kh.spring.dto.MessageDTO;

public class InputProcController implements Controller{
	
	@Autowired
	private MessageDAO mdao;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		String name = request.getParameter("name");
		String msg = request.getParameter("message");
		System.out.println(request.getRemoteAddr() + "님 입력-> " + name + "  :  " + msg);
		//기본적으로 annotation으로 쓰는것이 좋다. 그런데, annotation을 사용하지 못한다면 xml에 인스턴스 만들어서 쓰기.
		//bean을 만들면 autowired
		try {
			mdao.insert(new MessageDTO(0,name,msg));
			System.out.println("DB입력성공");
		}catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:error.do");
			return mav;
		}
		mav.setViewName("redirect:/");//포워딩을 해주면, name / msg 정보를 가지고 가므로
		//포워딩 하지말고 sendRedirect해줘야한다.
		//redirect방법은 "redirect:(가고싶은 url패턴)" 이다.
		return mav;
	}

}
