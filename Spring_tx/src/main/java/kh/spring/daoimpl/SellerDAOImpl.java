package kh.spring.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kh.spring.dao.SellerDAO;
import kh.spring.dto.SellerDTO;

@Component
public class SellerDAOImpl implements SellerDAO{
//	@Autowired
//	private DataSource ds;
	//homeController 로 DataSource를 빼놓는다.
	
	@Autowired
	private JdbcTemplate template;
	
	public int insertPay(Connection con ,SellerDTO dto) throws Exception{
		String sql = "insert into seller values(seller_seq.nextval,?,?)";
		try(
//				Connection con = this.ds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				
				){
			pstat.setString(1, dto.getBid());
			pstat.setString(2, dto.getPid());
			int result = pstat.executeUpdate();
//			con.commit();
			return result;
		}
	}
	
	public int insertPay(SellerDTO dto) throws Exception{
		String sql = "insert into seller values(seller_seq.nextval,?,?)";
		return template.update(sql, dto.getBid(),dto.getPid());
	}
}
