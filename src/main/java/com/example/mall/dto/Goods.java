package com.example.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

	private int obsid;
	private String obsname;
	private int obsprice;
	private int obscount;
	 
}
