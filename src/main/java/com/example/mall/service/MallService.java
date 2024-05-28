package com.example.mall.service;


import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mall.dao.IMalldao;
import com.example.mall.dto.Membersdto;

@Service
public class MallService {

	@Autowired
	private IMalldao imd;
	
	public void signin(Membersdto mto) {
		
		imd.memberjoin(mto);
	}
	/*
	public void login(String username, String password) {
	
		imd.login(username, password);
	}*/
	
	public Membersdto login(Membersdto member) {
        Optional<Membersdto> loginMember = imd.findByMemIdAndMemPw(member.getUsername() , member.getPassword());
        return loginMember.orElse(null);
		
    }
	
	
	
	
	
}
