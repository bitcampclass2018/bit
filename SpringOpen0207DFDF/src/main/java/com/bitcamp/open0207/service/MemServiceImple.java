package com.bitcamp.open0207.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitcamp.open0207.dao.MemberOpenDao2;
import com.bitcamp.open0207.model.Member2;
import com.bitcamp.open0207.model.MemberVO;

@Service
public class MemServiceImple implements MemService {

	@Inject
	private MemberOpenDao2 dao;
	
	@Override
	public void regMember(Member2 member) {
		dao.insertMember(member);
	}

	@Override
	public void updatePwd(String id, String pwd) {
		dao.updatePwd(id,pwd);
	}

	@Override
	public void delete(String id) {
		dao.delete(id);
	}

	@Override
	public List<Member2> MemberList() throws Exception {
		return dao.selectList();
	}

	@Override
	public Member2 selectMember(String id) {
		return dao.selectById(id);
	}

}
