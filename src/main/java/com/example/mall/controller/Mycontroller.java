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
public class Mycontroller {

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
	         Membersdto member = (Membersdto)memdao.userInfo(username);
	         session.setAttribute("loginMember", member);
	         System.out.println(member);
	         return "redirect:/";
	      } else {
	         model.addAttribute("errorMessage", "아이디나 비밀번호가 틀렸습니다. 다시 입력해주세요.");
	         return "login";
	      }
	   }
	  	   
	  @RequestMapping("list") //로그인시 여기로 오게할예정
	  public String getList(Model model) {
		  System.out.println("리스트 불러오기");
		  List<Goods> goodsList = msc.getGoodsList();
		  System.out.println(goodsList);
		  model.addAttribute("list", goodsList);
		  		  
		  return "list";
	  }
	  
	  @RequestMapping("writeform")
	  public String writegoodsForm() {
		  
		  
		  return"writegoods";
	  }
	  @RequestMapping("writegoods")
	  public String writegoods(Model model, HttpServletRequest request) {
		  
		  memdao.writegoods(request.getParameter("odsname"), request.getParameter("odsprice"), request.getParameter("content"));
		  
		  return"redirect:/";
	  }

	  @RequestMapping("/user/detail")
	  public String deatailpage(@RequestParam("odsid") int odsid, Model model) {
		  
		 
		  model.addAttribute("detaillist" , memdao.detiallist(odsid));
		  
		  return"/user/detail";
	  }
	  
	  
	  
	  
	  
	  
}
