package com.example.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

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
	//public int writegoods(String odsname, String odsprice, String content, String goodsimg);
	public int writegoods(@Param("goods") Goods goods);
	//디테일
	//public List<Goods> goodslistdetail(@Param("odsid") String odsid);
	
	public Goods detiallist(@Param("odsid") int odsid);
	
	public int sendcart();
}
