package com.example.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mall.dto.Membersdto;
import com.example.mall.dto.Mypagedto;

@Mapper
public interface IMemberdao {

	Membersdto getMemberById(int id);
	
	public List<Mypagedto> mypageList();
	
	
	
}
