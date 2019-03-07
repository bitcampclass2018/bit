package com.bitcamp.open0207.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.open0207.model.Member;
import com.bitcamp.open0207.model.Member2;
import com.bitcamp.open0207.model.MemberVO;

@Repository
public class MemberOpenDao2 {
	
	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.bitcamp.open0207.mapper.mybatis.memberMapper2";
	
	public int insertMember(Member2 member) {
		return sqlSession.insert(namespace+".insertMember", member);
	}
	public List<Member2> selectList() {
		return sqlSession.selectList(namespace+".selectList");
	}
	
	public Member2 selectById(String id) {
		return sqlSession.selectOne(namespace+".selectById", id);
	}
	public int delete(String id) {
		return sqlSession.delete(namespace+".delete", id);
	}
	public int updatePwd(String id, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("password", password);
		map.put("id", id);
		return sqlSession.update(namespace+".updatePwd", map);
	}
}
