package com.example.mall.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mall.dao.IMalldao;
import com.example.mall.dto.Membersdto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IMalldao memdao;
	
	@RequestMapping("/writeform")
	  public String writegoodsForm(HttpServletRequest request, Model model) {
		  
		HttpSession session = request.getSession();
		Membersdto member = (Membersdto) session.getAttribute("loginMember");
		if(member == null || !member.getRole().equals("ROLE_ADMIN")){
			
			model.addAttribute("foradmin", "관리자 페이지입니다.");
			return "redirect:/";
			
		}else {
			
			
			return"/admin/writegoods";
			
		}
		
		  
	  }
	  
	  @RequestMapping("/writegoods")
	  public String writegoods(Model model, HttpServletRequest request) {
		  
		  memdao.writegoods(request.getParameter("odsname"), request.getParameter("odsprice"), request.getParameter("content"));
		  
		  return"redirect:/";
	  }
	  
	  
	  
	  
}
