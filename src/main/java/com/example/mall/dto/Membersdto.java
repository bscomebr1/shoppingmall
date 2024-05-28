package com.example.mall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Membersdto {

	private int id;
	private String username;
	private String password;
	private String role;
}
