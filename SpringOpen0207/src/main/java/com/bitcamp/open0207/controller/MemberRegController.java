package com.bitcamp.open0207.controller;

import java.io.File;

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
import com.bitcamp.open0207.service.MemberRegService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	@Inject
	private MemberRegService regService;
	
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
			) {
	
		
		System.out.println("전달받은 값"+email +" : "+pw +" : "+name+" : "+file.getOriginalFilename());
		
		Member member = new Member();
		member.setId(id);
		member.setPassword(pw);
		member.setEmail(email);
		
		member.setName(name);
		
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

		//member.setPhoto(fileName);
		regService.memberReg(member);
		
		
		return "member/insert";
	}
	
	
}


