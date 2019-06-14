package kh.spring.practice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kh.spring.dao.MessageDAO;
import kh.spring.dto.MessageDTO;

public class OutputProcController implements Controller{
	@Autowired
	private MessageDAO dao;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		try {
			List<MessageDTO> list = dao.selectAll();
			mav.addObject("list", list); //MVC2에서 request.setAttribute() 와 같은역할.
		}catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:error.do");
		}

		mav.setViewName("WEB-INF/output/showList.jsp");
		return mav;
	}

}
