package kh.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.MessageDTO;

@Component
public class MessageDAO {
	@Autowired
	private DataSource ds;
	
	public int insertMsg(MessageDTO dto) throws Exception{
		String sql = "insert into message values(message_seq.nextval,?,?)";
		try(
				Connection con = this.ds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				
				){
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getMsg());
			
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}
	}
	
	public List<MessageDTO> selectAll() throws Exception{
		String sql = "select * from message";
		try(
				Connection con = this.ds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();
				){
			List<MessageDTO> list = new ArrayList<>();
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String name = rs.getString("name");
				String msg = rs.getString("msg");
				list.add(new MessageDTO(seq,name,msg));
			}
			return list;
		}
	}
}
