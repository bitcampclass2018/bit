package com.bitcamp.open0207.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitcamp.open0207.dao.BoardDao;
import com.bitcamp.open0207.model.Board;

@Service
public class BoardService {
	
	@Inject
	private BoardDao dao;
	
	public int insertBoard(Board board) {
		return dao.insertBoard(board);
	}
	public List<Board> selectBoardList(){
		return dao.selectBoardList();
	}
}
