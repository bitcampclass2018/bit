package com.bitcamp.open0207.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.open0207.model.Emp;

@Repository
public class EmpDao {
	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.bitcamp.open0207.mapper.mybatis.memberMapper";
	
	public int insertEmp(Emp emp) {
		return sqlSession.update(namespace+".insertEmp", emp);
	}
	public List<Emp> selectEmpList(){
		return sqlSession.selectList(namespace+".selectEmpList");
	}
}
