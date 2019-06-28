package kh.spring.dao;

import java.sql.Connection;

import kh.spring.dto.SellerDTO;

public interface SellerDAO{
	public int insertPay(Connection con ,SellerDTO dto) throws Exception;
	public int insertPay(SellerDTO dto) throws Exception;
}
