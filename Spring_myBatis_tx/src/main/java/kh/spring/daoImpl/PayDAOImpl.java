package kh.spring.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dao.PayDAO;
import kh.spring.dto.PayDTO;

@Repository
public class PayDAOImpl implements PayDAO{

	@Autowired
	private SqlSessionTemplate sst;
	
	public int insertPay(PayDTO dto) {
		return sst.insert("PayDAOImpl.insert",dto);
	}
	
}
