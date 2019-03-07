package com.bitcamp.open0207.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberRegFormController {
	@RequestMapping("/member/regForm")
	public String getRegForm() {
		return "member/regForm";
	}
	//Rest용 회원가입폼.
	@RequestMapping("/rest/regForm")
	public String getForm() {
		return "restRegForm";
	}
	@RequestMapping("/rest/updateForm")
	public String getUpdateForm() {
		return "restUpdateForm";
	}
}
