package com.bitcamp.open0207.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NaverController {

	
	@RequestMapping("/member/callback")
	public String naverCallback() {
		return "member/callback";
	}
}
