package com.bitcamp.open0207.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	@RequestMapping("/member/logout")
	 public String sessionRemove(HttpServletRequest request,
			 HttpSession session) {
		String s = (String)session.getAttribute("loginInfo");
		System.out.println("session지우기"+s);
	  session.removeAttribute("loginInfo");

	  return "member/logout";

	 }



}
