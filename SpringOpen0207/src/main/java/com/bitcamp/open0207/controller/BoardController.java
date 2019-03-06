package com.bitcamp.open0207.controller;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.open0207.model.Board;
import com.bitcamp.open0207.model.Member;
import com.bitcamp.open0207.service.BoardService;

@Controller
public class BoardController {
	
	@Inject
	private BoardService bService;
	
	@RequestMapping(value="/board/insert", method=RequestMethod.GET)
	public String getForm() {
		return "board/boardForm";
	}
	@RequestMapping(value="/board/insert", method=RequestMethod.POST) 
	public String insertBoard(HttpServletRequest request,
			@RequestParam("upw") String pw,
			@RequestParam("umessage") String message,
			HttpSession session
			) {

		String s = (String)session.getAttribute("loginInfo");
		
		Board board = new Board();
		board.setMember_id(s);
		board.setPassword(pw);
		board.setMessage(message);
		
		bService.insertBoard(board);
		
		
		return "board/insert";
	}
	
	@RequestMapping("/board/list")
	public String selectList(Model model) {
		List<Board> boards = bService.selectBoardList();
		model.addAttribute("boards", boards);
		return "board/boardList";
	}
	
}
