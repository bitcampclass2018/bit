package com.bitcamp.open0207.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.open0207.model.Board;

@Repository
public class BoardDao {
	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.bitcamp.open0207.mapper.mybatis.memberMapper";
	
	public int insertBoard(Board board) {
		return sqlSession.update(namespace+".insertBoard", board);
	}
	public List<Board> selectBoardList(){
		return sqlSession.selectList(namespace+".selectBoardList");
	}
}
