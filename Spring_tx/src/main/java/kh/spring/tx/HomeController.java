package kh.spring.tx;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dao.PayDAO;
import kh.spring.dao.SellerDAO;
import kh.spring.dto.PayDTO;
import kh.spring.dto.SellerDTO;
import kh.spring.service.BuyService;

@Controller
public class HomeController {
	//-------HomeController가 connection해서 사용할때------------------
	@Autowired
	private DataSource ds;
	
	@Autowired
	private PayDAO p_dao;
	
	@Autowired
	private SellerDAO s_dao;
	//-------------------------
	
	@Autowired
	private BuyService buyService;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/")
	public String home() {
		session.setAttribute("id","tmpId");
		return "home";
	}
	
	
	//pay테이블 -> int seq , String pid , String pname
	
	//1단계. 이전에 사용했던것처럼 dao에서 commit하는 방법
	@RequestMapping("buy.do")//DataSource가 dao안에 있을때의 코드
	public String buyProc(PayDTO dto) {
		System.out.println(dto.getPid() + " : " + dto.getPname());
		int result_p =0;
		int result_s = 0;
		try {
//			result_p = p_dao.insertPay(dto);
//			result_s = s_dao.insertPay(new SellerDTO(0,(String)session.getAttribute("id"),dto.getPid()));
			//pay테이블에 insert 되고나서, seller테이블에 insert하는데 오류가 발생했다면
			//트랜잭션 원자성을 지키기위해 둘다 insert되지 않는것이 좋다.
			
			//그래서 각 dao의 insert메소드안에서 commit 을 하는것이아니라 
		} catch (Exception e) {
			e.printStackTrace();
			//여기서는 rollback을 해야하고
			return "error";
		}
		//여기서는 commit을 해줘야 작업의 원자성을 가질수있다.
		System.out.println(result_p +":"+result_s);
		return "home";
	}
	
	//2단계. HomeController에서 connection 관리
	@RequestMapping("buy.ds")//DataSource가 HomeController에 있을때,
	public String buyProcWithDS(PayDTO dto) {
		Connection con = null;
		try {
			con = this.ds.getConnection();
			s_dao.insertPay(con, new SellerDTO(0,(String)session.getAttribute("id"),dto.getPid()));
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
		}finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return "home";
	}
	
	//3단계. service layer를 사용해 트랜잭션 처리
	@RequestMapping("buy.service")
	public String buyProcWithService(PayDTO dto) {
		String id = (String)session.getAttribute("id");
		try {
//			buyService.buy(dto, id); //->jdbc로 insert할때 service
			buyService.buyWithSpringJdbc(dto, id); //-> spring jdbc로 insert할때 service
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home";
	}
}
