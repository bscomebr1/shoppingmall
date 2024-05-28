package com.example.mall.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.dao.IMalldao;
import com.example.mall.dto.Goods;
import com.example.mall.dto.Membersdto;

@Service
public class MallService {

	@Autowired
	private IMalldao imd;
	
	public void signin(Membersdto mto) {
		
		imd.memberjoin(mto);
	}
	
	public List<Goods> getGoodsList() {
		List<Goods> list = imd.goodslist();
				
		return list;
		
	}
	
		
	
	
	
}
