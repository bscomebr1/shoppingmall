package com.example.mall.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.mall.dto.Goods;
import com.example.mall.dto.Membersdto;

@Mapper
public interface IMalldao {

	//회원가입
	public void memberjoin(@Param("mdt")Membersdto mdt);
		
	//로그인 아이디체크
	public Membersdto userInfo(String username);
	
	public int loginCheck(@Param("username") String username, @Param("password") String password);
	
	//상품리스트
	public List<Goods> goodslist();
	
	//등록
	public int writegoods(String odsname, String odsprice, String content);
	
	
	
}
