package kh.spring.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kh.spring.dao.PayDAO;
import kh.spring.dto.PayDTO;
@Component
public class PayDAOImpl implements PayDAO{
	
	@Autowired
	private JdbcTemplate template;
	
//	@Autowired
//	private DataSource ds;
	
	public int insertPay(Connection con,PayDTO dto) throws Exception{
		String sql = "insert into pay values(pay_seq.nextval,?,?)";
		try(
//				Connection con = this.ds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				
				){
			pstat.setString(1, dto.getPid());
			pstat.setString(2, dto.getPname());
			int result = pstat.executeUpdate();
//			con.commit();
			return result;
		}
	}
	
	public int insertPay(PayDTO dto) throws Exception{
		String sql = "insert into pay values(pay_seq.nextval,?,?)";
		return template.update(sql, dto.getPid(),dto.getPname());
	}
}
