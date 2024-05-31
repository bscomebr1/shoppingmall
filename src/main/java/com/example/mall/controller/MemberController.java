package com.example.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mall.dao.ICartdao;
import com.example.mall.dao.IMalldao;
import com.example.mall.dao.IMemberdao;
import com.example.mall.dto.Membersdto;
import com.example.mall.dto.Mypagedto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class MemberController {

	@Autowired
	private IMalldao memdao;
	@Autowired
	private ICartdao cartdao;
	@Autowired
	private IMemberdao memberdao;
	
	
	 @RequestMapping("/mypage")
	  public String mypage(HttpServletRequest request, Model model) {
		  
		 HttpSession session = request.getSession();
		 Membersdto member = (Membersdto) session.getAttribute("loginMember");
		 
		 
		 
		 List<Mypagedto> mypagelist = memberdao.mypageList(); 
		 model.addAttribute("my",mypagelist);		 
		 return "/user/mypage";
	  }
	 
	 
	 @RequestMapping("/sendcart")
	  public String sendcart(HttpServletRequest request, @RequestParam("memberid") int memberid, @RequestParam("odsid") int odsid, @RequestParam("odsname") String odsname, @RequestParam("cartcount") int cartcount) {
		  
		 HttpSession session = request.getSession();
		 Membersdto member = (Membersdto) session.getAttribute("loginMember");
		
		 System.out.println("멤버아이디" + memberid);
		 System.out.println("상품코드"+odsid);
		 System.out.println("상품명" + odsname);
		 System.out.println("장바구니에 넣는수" + cartcount);
		  
		 cartdao.writeCart(memberid, odsid, odsname, cartcount);
		
		  return "redirect:/";
	  }
	 
	 @RequestMapping("/detail")
	  public String deatailpage(@RequestParam("odsid") int odsid, Model model, HttpServletRequest request) {
		 
		  
		 HttpSession session = request.getSession();
		 Membersdto member =  (Membersdto)session.getAttribute("loginMember");
		 System.out.println("member입니다 --" + member);
		 if (member == null) {
			 model.addAttribute("loginError", "로그인이 필요합니다");
		        return "redirect:/loginform"; // Adjust this path to your actual login page URL
		 }else {
			 int id = member.getId();
			 System.out.println("id : " + id);
			 model.addAttribute("username", session.getAttribute("loginmember"));
			 
			 model.addAttribute("detaillist" , memdao.detiallist(odsid));
			 return"/user/detail";
		 }
	 
	 }
}
