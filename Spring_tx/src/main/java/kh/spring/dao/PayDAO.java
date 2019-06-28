package kh.spring.dao;

import java.sql.Connection;

import kh.spring.dto.PayDTO;

public interface PayDAO {
	
	public int insertPay(Connection con,PayDTO dto) throws Exception;
	public int insertPay(PayDTO dto) throws Exception;
	
}
