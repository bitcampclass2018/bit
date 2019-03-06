package com.bitcamp.open0207.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.open0207.model.Member;
import com.bitcamp.open0207.service.LoginService;

@Controller
public class viewController {
	@Inject
	private LoginService logService;
	
	@RequestMapping("/member/view")
	public String selectById(HttpServletRequest request,
			HttpSession session,
			Model model) {
		String s = (String)session.getAttribute("loginInfo");
		System.out.println("session값 "+s);
		Member member = logService.selectById(s);
		model.addAttribute("result", member);
		return "member/view";
	}
	@RequestMapping("/member/list")
	public String selectList(Model model) {
		List<Member> members = logService.selectList();
		model.addAttribute("members", members);
		return "member/list";
	}
	
}
