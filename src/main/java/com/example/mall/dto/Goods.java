package com.example.mall.dto;

import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

	private int odsid;
	private String odsname;
	private int odsprice;
	private String content;
	private String goodsimg;
	
	
	public String getGoodsimg() {
		return goodsimg;
	}
	public void setGoodsimg(String goodsimg) {
		this.goodsimg = goodsimg;
	}
	
	
	private static ModelMapper modelMapper = new ModelMapper();

	public static Goods of(Goodsfile goodsfile) {
		return modelMapper.map(goodsfile, Goods.class);
	}
  
}
