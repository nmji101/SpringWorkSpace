package kh.spring.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.dto.PayDTO;
import kh.spring.dto.SellerDTO;
import kh.spring.service.BuyService;

@Component
public class BuyServiceImpl implements BuyService{
	//구매과정 트랜잭션에 대한 service
	//jdbc쓸때 필요한 DataSource
	@Autowired
	private DataSource ds;
	
	@Autowired
	private PayDAOImpl p_dao;
	
	@Autowired
	private SellerDAOImpl s_dao;
	
	
//	pay table 에 insert를 해라.
	public void buy(PayDTO dto, String id) throws Exception{
		//지금은 jdbc를쓰니까 트랜잭션을 관리할수있는데
		//spring jdbc가 트랜잭션관리하는 어노테이션을제공한다.
		Connection con = null;
		try {
			con = this.ds.getConnection();
			s_dao.insertPay(con, new SellerDTO(0,id,dto.getPid()));
			System.out.println("SellerTable insert");
			
			p_dao.insertPay(con , dto);
			System.out.println("PayTable insert");
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
			try {
				System.out.println("error! rollback");
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	/**
	 * 스프링 jdbc이용해서 insert하는 메소드
	 * @param dto
	 * @param id
	 * @throws Exception
	 */
	@Transactional("txManager"/*context.xml에 만들어둔 txmanager이름*/)// 트랜잭션 처리해달라는 어노테이션
	public void buyWithSpringJdbc(PayDTO dto, String id) throws Exception{
		s_dao.insertPay(new SellerDTO(0,id,dto.getPid()));
		System.out.println("SellerTable insert");
		p_dao.insertPay(dto);
		System.out.println("PayTable insert");
	}
}
