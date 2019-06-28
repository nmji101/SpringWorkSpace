package kh.spring.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dao.SellerDAO;
import kh.spring.dto.SellerDTO;

@Repository
public class SellerDAOImpl implements SellerDAO{
	@Autowired
	private SqlSessionTemplate sst; 
	
	@Override
	public int insertSeller(SellerDTO dto) {
		return sst.insert("SellerDAOImpl.insert",dto);
	}

}
