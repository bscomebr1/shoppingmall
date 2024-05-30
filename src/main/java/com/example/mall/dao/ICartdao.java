package com.example.mall.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.mall.dto.Cartdto;

@Mapper
public interface ICartdao {

	//장바구니 등록
	public void writeCart(@Param("id") int id, @Param("goodsid") int goodsid , @Param("odsname") String odsname, @Param("cartcount") int cartcount);
	
}
