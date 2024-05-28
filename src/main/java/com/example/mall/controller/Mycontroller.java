package com.example.mall.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mall.dao.IMalldao;
import com.example.mall.dto.Goods;
import com.example.mall.dto.Membersdto;
import com.example.mall.service.MallService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class Mycontroller {

	@Autowired
	private MallService msc;
	
	@Autowired
	private IMalldao memdao;

	  @GetMapping("/")
	    public String index() {
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
	  /*
	  @RequestMapping("login")
	  public String login(@RequestParam("username")String username, @RequestParam("password")String password, HttpSession session) {
		  
		 User user = msc.login(username, password);
		  
		 if(user != null) {
			 session.setAttribute("member", user);
			 return "redirect:/";
		 } else {
	            return "redirect:/login?error=true";
	        }
	  }
	  */
	  @RequestMapping("/login")
	   public String loginCheck(HttpServletRequest request, HttpSession session, Model model) {
	      String username = request.getParameter("username");
	      String password = request.getParameter("password");
	      
	      int result = memdao.loginCheck(username, password);
	      System.out.println(result);
	      
	      if(result == 1) {
	         Membersdto member = (Membersdto)memdao.userInfo(username);
	         session.setAttribute("loginMember", member);
	         System.out.println(member);
	         return "redirect:/";
	      } else {
	         model.addAttribute("errorMessage", "아이디나 비밀번호가 틀렸습니다. 다시 입력해주세요.");
	         return "login";
	      }
	   }
	  	  
		  
	  @RequestMapping("list")
	  public String getList(Model model) {
		  
		  List<Goods> goodslist = memdao.goodslist(); 
		  model.addAttribute("list",goodslist);
		  
		  System.out.println(goodslist);
		  return "redirect:/";
	  }
	  
	  
	  
}
