package kh.spring.practice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller{
	//controller들은 모두 implements Controller 해야한다.
	//그런데 implement는 pojo에 위배되는 ... 것이다 
	//그래서 나중에 annotation으로 바뀌게된다. 
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("WEB-INF/index.jsp");//default가 forwarding이랑 같은역할
		return mav;
	}

}
