package com.example.mall.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.mall.dao.IMalldao;
import com.example.mall.dto.Goods;
import com.example.mall.dto.Goodsfile;
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
	  public String writegoods(HttpServletRequest request,@RequestParam("goodsimg") MultipartFile file,  Goodsfile goodsfile) {
		  
		  Goods goods = new Goods();
		  goods.setOdsname(goodsfile.getOdsname());
		  goods.setOdsprice(goodsfile.getOdsprice());
		  goods.setContent(goodsfile.getContent());
		  String originName = goodsfile.getFileName();
		  
		  String newName = UUID.randomUUID().toString() + "_" + originName;
		  goods.setGoodsimg(newName);
		  
		  File file2 = new File(goods.getGoodsimg());
			try {
		        file.transferTo(file2);
		        goods.setGoodsimg(newName);
				//goodsfile.getGoodsimg().transferTo(file2);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("어케들어가지 :" + goods);
			memdao.writegoods(goods);
		  //memdao.writegoods(request.getParameter("odsname"), request.getParameter("odsprice"), request.getParameter("content"),request.getParameter("goodsimg"));
		  
		  return"redirect:/";
	  }
	  
	  
	  
	  
}
