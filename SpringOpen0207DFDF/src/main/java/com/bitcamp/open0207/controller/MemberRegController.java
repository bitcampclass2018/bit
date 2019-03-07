package com.bitcamp.open0207.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.imageio.spi.RegisterableService;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.open0207.model.Member;
import com.bitcamp.open0207.service.MailSendService;
import com.bitcamp.open0207.service.MemberRegService;
import com.bitcamp.open0207.service.SecurityService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	@Inject
	private MemberRegService regService;
	
	@Inject
	private MailSendService mailService;
	
	@Inject
	private SecurityService securityService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getForm() {
		return "member/regForm"; //뷰의 이름을 반환함.
	}
	
	@RequestMapping(method=RequestMethod.POST) 
	public String memberReg(HttpServletRequest request,
			@RequestParam("uid") String id,
			@RequestParam("uemail") String email,
			@RequestParam("upw") String pw,
			@RequestParam("uname") String name,
			@RequestParam("uphoto") MultipartFile file
			) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
	
		
		System.out.println("전달받은 값"+email +" : "+pw +" : "+name+" : "+file.getOriginalFilename());
		
		String code = "abcdefghijklmnopqrstuvwxyz0123456789";
		String ckcode="";
		for(int i=0;i<5;i++) {
			int k =(int)(Math.random()*code.length());
			ckcode += code.charAt(k);
		}
		
		String sPw = securityService.makeCode(pw);
		Member member = new Member();
		member.setId(id);
		member.setPassword(sPw);
		member.setEmail(email);
		
		member.setName(name);
		member.setSit(0); //처음 가입시 상태 0
		member.setCkcode(ckcode); //보안처리한 아이디 넘겨주기.
		System.out.println("암호처리"+ckcode);
		
		String uri = "/upload";
		String dir = request.getSession().getServletContext().getRealPath(uri);
		System.out.println("dir"+dir);
		
		String fileName = file.getOriginalFilename();
		if(!file.isEmpty()) {
			try {
				file.transferTo(new File(dir, fileName));
				member.setPhoto(fileName);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			member.setPhoto("photo");
		}

		regService.memberReg(member);
		mailService.mailSender(email, ckcode);
		
		return "member/insert";
	}
	
	
}


