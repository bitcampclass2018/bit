package com.bitcamp.open0207.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.open0207.model.Member;
import com.bitcamp.open0207.service.MailSendService;
import com.bitcamp.open0207.service.MemberRegService;

@Controller
public class MailCkController {
	
	@Inject
	private MemberRegService mService;
	
	@RequestMapping("/Auth/code/{email}/{ckcode}")
	public String mailCk(HttpServletRequest request,
			@PathVariable("email") String email,
			@PathVariable("ckcode") String ckcode) {
		
		System.out.println("MailCkController : "+email+";"+ckcode);
		
		Member member=mService.mailCheck(email);
		String findcode = member.getCkcode();
		System.out.println("-----------");
		System.out.println(findcode);
		System.out.println(ckcode);
		System.out.println("-----------");
		if(findcode!=null&&ckcode.equals(findcode)) {
			System.out.println("두 코드의 값이 같습니다.");
			mService.mailCheckUp(email);
			System.out.println(member.toString());
		}
		
		return "member/mailcheck";
	}
	
	

	
}
