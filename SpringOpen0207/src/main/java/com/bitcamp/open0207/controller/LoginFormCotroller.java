package com.bitcamp.open0207.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginFormCotroller {
	@RequestMapping("/member/login")
	public String getLogin() {
		return "member/loginForm";
	}
}
