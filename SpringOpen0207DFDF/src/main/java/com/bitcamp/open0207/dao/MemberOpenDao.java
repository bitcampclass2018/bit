package com.bitcamp.open0207.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.open0207.model.Member;

@Repository
public class MemberOpenDao {
	
	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.bitcamp.open0207.mapper.mybatis.memberMapper";
	
	public int insertMember(Member member) {
		return sqlSession.update(namespace+".insertMember", member);
	}
	
	public Member selectById(String id) {
		return sqlSession.selectOne(namespace+".selectById", id);
	}
	public List<Member> selectList() {
		return sqlSession.selectList(namespace+".selectList");
	}
	public Member mailCheck(String email) {
		return sqlSession.selectOne(namespace+".selectByEmail",email);
	}
	public int mailCheckUp(String email) {
		return sqlSession.update(namespace+".updateSit",email);
	}
}
