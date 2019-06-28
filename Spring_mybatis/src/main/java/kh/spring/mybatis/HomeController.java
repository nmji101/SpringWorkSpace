package kh.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dao.MessageDAO;
import kh.spring.dto.MessageDTO;
import kh.spring.dto.TempDTO;


@Controller
public class HomeController {
	@Autowired
	private MessageDAO dao;
	
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("insert")
	public String insert() {
		dao.insert();
		return "home";
	}
	
	@RequestMapping("delete")
	public String delete() {
		dao.delete();
		return "home";
	}
	
	@RequestMapping("update")
	public String update() {
		dao.update();
		return "home";
	}
	
	@RequestMapping("select")
	public String select() {
		List<MessageDTO> list = dao.selectList();
		for(MessageDTO dto : list) {
			System.out.println(dto.toString());
		}
		return "home";
	}
	
	@RequestMapping("selectOne")
	public String selectOne() {
		MessageDTO dto = dao.selectBySeq();
		System.out.println(dto.toString());
		return "home";
	}
	
	@RequestMapping("tempDTO")
	public String selectByTempDTO() {
		TempDTO dto = dao.selectByTempDTO();
		System.out.println(dto.toString());
		return "home";
	}
	
}
