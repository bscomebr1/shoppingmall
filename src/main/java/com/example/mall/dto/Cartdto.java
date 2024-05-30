package com.example.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cartdto {

	private int cartid;
	private int memberid;
	private int goodsid;
	private String odsname;
	private int cartcount;
	
}
