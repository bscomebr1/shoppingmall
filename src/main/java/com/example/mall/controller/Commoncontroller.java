package com.example.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mall.dao.IMalldao;
import com.example.mall.dto.Goods;
import com.example.mall.dto.Membersdto;
import com.example.mall.service.MallService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class Commoncontroller {

	@Autowired
	private MallService msc;
	
	@Autowired
	private IMalldao memdao;

	  @GetMapping("/")
	    public String index(Model model, HttpSession session) {
	   
		  
		  System.out.println("리스트 불러오기");
		  List<Goods> goodsList = msc.getGoodsList();
		  System.out.println(goodsList);
		  model.addAttribute("list", goodsList);
		  
		  String username = (String) session.getAttribute("username");
		  if (username != null) {
			  model.addAttribute("username", true);
		  }else {
			  model.addAttribute("username", false);
		  }

		  return "index"; 
	    }
	  
	  @RequestMapping("signinform")
	  public String signinform() {
		  
		  return "signin";
	  }
	  @RequestMapping("signin")
	  public String signin(Membersdto mem) {
		
		msc.signin(mem);
		  
		  return "redirect:/";
	  }
	  
	  @RequestMapping("loginform")
	  public String loginform() {
		  
		  return "login";
	  }
	
	  @RequestMapping("/login")
	   public String loginCheck(HttpServletRequest request, HttpSession session, Model model) {
	       String username = request.getParameter("username");
	      String password = request.getParameter("password");
	      
	      int result = memdao.loginCheck(username, password);
	      System.out.println(result);
	      
	      if(result == 1) {
	         Membersdto member = memdao.userInfo(username);
	         
	         session.setAttribute("loginMember", member);
	         session.setAttribute("loginname", member.getUsername());
	         session.setAttribute("loginadmin",member.getRole());
	         System.out.println("맴버에 뭐가 담기는지 :"+member);
	         return "redirect:/";
	      } else {
	         model.addAttribute("errorMessage", "아이디나 비밀번호가 틀렸습니다. 다시 입력해주세요.");
	         return "login";
	      }
	   }
	  
	  @RequestMapping("/logout")
	  public String logout() {
		  
		  
		  return"redirect:/";
	  }
	  @GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
	  
	  	   
	  @RequestMapping("list") 
	  public String getList(Model model) {
		  List<Goods> goodsList = msc.getGoodsList();
		  model.addAttribute("list", goodsList);
		  		  
		  return "list";
	  }
	  
	  

	  
		   
		  
	  }
	  
	  