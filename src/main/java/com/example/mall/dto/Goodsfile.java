package com.example.mall.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goodsfile {

	private int odsid;
	private String odsname;
	private int odsprice;
	private String content;
	private MultipartFile goodsimg;
	
	public String getFileName() {
		return goodsimg.getOriginalFilename();
	}
	
	
	
}
