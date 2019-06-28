package kh.spring.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.daoImpl.PayDAOImpl;
import kh.spring.daoImpl.SellerDAOImpl;
import kh.spring.dto.PayDTO;
import kh.spring.dto.SellerDTO;
import kh.spring.service.BuyService;

@Service
public class BuyServiceImpl implements BuyService{
	@Autowired
	private PayDAOImpl p_dao;
	
	@Autowired
	private SellerDAOImpl s_dao;
	
	@Override
	@Transactional("txManager")
	public void buy(PayDTO dto, String id) {
		s_dao.insertSeller(new SellerDTO(0,id,dto.getPid()));
		System.out.println("SellerTable insert");
		p_dao.insertPay(dto);
		System.out.println("PayTable insert");
	}

}
