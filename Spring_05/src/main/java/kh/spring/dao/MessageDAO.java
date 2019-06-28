package kh.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kh.spring.dto.MessageDTO;

@Component
public class MessageDAO {
	
//	@Autowired
//	private DataSource ds;
	
	//spring-jdbc사용하기
	@Autowired
	private JdbcTemplate template;
	//장점 -> close알아서하고 commit도 알아서 적용된다.
	
	public int insertMsg(MessageDTO dto){
		String sql = "insert into message values(message_seq.nextval,?,?)";
		//spring-jdbc가 알아서 commit close 해주기때문에 try-resources 도 필요없고 commit도 필요없다.
		return template.update(sql, /*물음표 순서대로 넣어줌*/dto.getName(),dto.getMsg());
	}
	
	public List<MessageDTO> selectAll(){
		String sql = "select * from message";
		//template.queryForObject(sql, requiredType)//테이블에서 하나만 뽑고싶을때
		return template.query(sql, new RowMapper<MessageDTO>() {

			@Override
			public MessageDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				//ResultSet의 하나의 row에 대해 어떻게 처리할것인지 정보를 알려주는것
				
				//cf 데이터베이스의 컬럼정보를 주면 맵핑도 알아서 해주는 타이거..네..?스..? 
				MessageDTO dto = new MessageDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setName(rs.getString("name"));
				dto.setMsg(rs.getString("msg"));
				return dto;
			}
			
		}); //테이블 record전체를 얻고싶을때
		//RowMapper : 인터페이스
		//특정 추상 method를 갖고있음. -> 그래서 익명인스턴스만들고 바로 오버라이딩해서 사용한다.

	}
}
