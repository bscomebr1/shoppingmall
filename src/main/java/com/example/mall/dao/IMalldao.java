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
	//로그인
	public void login(@Param("username") String username, @Param("password") String password);
	//로그인 사용하는거

	Optional<Membersdto> findByMemIdAndMemPw(@Param("username") String username, @Param("password") String password);
	
	public Membersdto userInfo(String username);
	public int loginCheck(@Param("username") String username, @Param("password") String password);
	
	//상품리스트
	List<Goods> goodslist();
	
	
	
}
