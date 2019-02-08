package com.bitcamp.open0207.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.bitcamp.open0207.dao.MemberOpenDao;
import com.bitcamp.open0207.model.Member;

@Service
public class LoginService {
	
	@Inject
	private MemberOpenDao dao;

	public Member selectById(String id) {
		return dao.selectById(id);
	}
	
	public List<Member> selectList(){
		return dao.selectList();
	}
}
