package kh.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MessageDTO;
import kh.spring.dto.TempDTO;

//dao들은 @Component 대신에 @Repository를 붙여준다. 같은기능인데 그냥 단지 구분을위해서
//service들도 @Service 어노테이션 사용

@Repository
public class MessageDAO {
	//mybatis로 db 쿼리 날리기.
	@Autowired
	private SqlSessionTemplate sst; 
	
	public int insert() {
		MessageDTO dto = new MessageDTO();
		dto.setName("yhy");
		dto.setMsg("MyBatis");
		System.out.println("msg DB입력하기!");
		return sst.insert(/*namespace.내가부를쿼리문의id*/"MessageDAO.insert",dto);
	}
	public int delete() {
		//param으로 1을 넘기면 mapper에서 #{value}로 받아준다.
		int seq = 60;
		System.out.println("msg DB seq : " + seq +" 번 삭제");
		return sst.delete("MessageDAO.delete",seq);
	}
	
	public List<MessageDTO> selectList(){
		System.out.println("====현재 msg목록====");
		return sst.selectList("MessageDAO.selectList");
	}
	
	public MessageDTO selectBySeq() {
		int seq = 62;
		System.out.println("msg DB seq : " + seq +" 번 조회");
		return sst.selectOne("MessageDAO.selectBySeq", seq);
	}
	
	public int update() {
		MessageDTO dto = new MessageDTO();
		dto.setSeq(70);
		dto.setMsg("modify-> MyBatis");
		System.out.println("msg DB에서 [" + dto.getSeq() +"]번의 메세지를 [" + dto.getMsg() +"]로 변경하기 ");
		return sst.update("MessageDAO.update",dto);
	}
	
	public TempDTO selectByTempDTO(){
		TempDTO dto = new TempDTO(75, "asd", "null");
		return sst.selectOne("MessageDAO.selectByTempDTO",dto);
	}
}
