package com.bitcamp.open0207.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.open0207.model.Member;
import com.bitcamp.open0207.service.LoginService;

@Controller
@RequestMapping("/member/login")
public class LoginController {
	
	@Inject
	private LoginService logService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getForm() {
		return "member/loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(HttpServletRequest request,
			HttpServletResponse response,
	@RequestParam("uid") String id,
	@RequestParam("upw") String password,
	Model model,
	HttpSession session) {
		Member member = logService.selectById(id);
		String findPw = member.getPassword();
		int findSit = member.getSit();
		model.addAttribute("result", member);
		
		String url = request.getParameter("url");
		System.out.println("넘어온 url"+url);
		
		if(findSit==0) {
			return "member/loginFail";
		}
		if(findPw!=null&&findPw.equals(password)) {
			session.setAttribute("loginInfo", id);
			System.out.println("session생성 : "+id);
			
			if(!(url==null||url.equals(""))) {
				try {
					response.sendRedirect(request.getContextPath()+url);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return "member/login";
		}
		return "member/loginForm";
	}
}
