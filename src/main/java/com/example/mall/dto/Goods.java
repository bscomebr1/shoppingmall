package com.example.mall.dto;

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
	 
}
