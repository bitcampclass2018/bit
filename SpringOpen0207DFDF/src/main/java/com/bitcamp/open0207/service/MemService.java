package com.bitcamp.open0207.service;

import java.util.List;

import com.bitcamp.open0207.model.Member2;

public interface MemService {
	public void regMember (Member2 member2);
	public void updatePwd (String oldPwd, String newPwd);
	public void delete (String id);
	public List<Member2> MemberList() throws Exception;
	public Member2 selectMember(String id);
}
