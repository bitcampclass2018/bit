package com.bitcamp.open0207.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitcamp.open0207.dao.MemberOpenDao;
import com.bitcamp.open0207.model.Member;

@Service
public class MemberRegService {
	
	@Inject
	private MemberOpenDao dao;
	
	public int memberReg(Member member) {
		return dao.insertMember(member);
	}
}
