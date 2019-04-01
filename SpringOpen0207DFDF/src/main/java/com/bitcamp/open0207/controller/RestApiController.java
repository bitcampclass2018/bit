package com.bitcamp.open0207.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.open0207.model.Member;
import com.bitcamp.open0207.model.Member2;
import com.bitcamp.open0207.model.MemberList;
import com.bitcamp.open0207.service.LoginService;
import com.bitcamp.open0207.service.MemServiceImple;


@RestController
@RequestMapping("/rest")
public class RestApiController {
	
	@Inject
	private LoginService logService;
	
	
	@Inject
	private MemServiceImple memService;
	
	@PostMapping("/regMember")
	public Member2 insert(@RequestBody Member2 member) {
		memService.regMember(member);
		return member;
	}
	
	@RequestMapping("/list")
	public List<Member2> getMemberList() throws Exception {
		return memService.MemberList();
	}
	
	
	
	@GetMapping("/{id}")
	public Member2 getMember(@PathVariable("id") String id) {
		return memService.selectMember(id);
	}
	
	@PutMapping("/{id}")
	public Member2 updatePwd(@PathVariable("id") String id,
			@RequestBody Map<String, Object> params) {
		String pwd = (String) params.get("password");
		System.out.println("updatePwd;"+pwd);
		memService.updatePwd(id, pwd);
		return memService.selectMember(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		memService.delete(id);
	}
	
}
