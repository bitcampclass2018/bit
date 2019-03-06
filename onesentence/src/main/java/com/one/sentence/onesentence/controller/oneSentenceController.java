package com.one.sentence.onesentence.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.one.sentence.onesentence.model.Book;
import com.one.sentence.onesentence.model.Onesentence;
import com.one.sentence.onesentence.service.OnesentenceService;

@Controller
public class oneSentenceController {
	
	@Inject
	OnesentenceService oneService;

	@RequestMapping(value="/onesentence/insert", method=RequestMethod.GET)
	public String getForm() {
		return "onesentence/insert";
	}
	
	@RequestMapping(value="/onesentence/insert", method=RequestMethod.POST)
	public String insertOnesententce(HttpServletRequest request,
			@RequestParam("oneSentence") String oneSentence,
			@RequestParam("isbn") int isbn,
			@RequestParam("page") String page,
			@RequestParam("userIdx") int userIdx,
			Model model
			) {

		System.out.println(isbn+":"+page+":"+oneSentence+":"+userIdx);
		
		if(oneService.showBookByisbn(isbn)==null) {
			
			Book book = new Book();
			//String author = request.getParameter("author");
			String author = "권재진";
			String bookGenre = "공포소설";
			String bookTitle = "한지민";
			String publisher = "비트출판사";
			
			book.setIsbn(isbn);
			book.setAuthor(author);
			book.setBookGenre(bookGenre);
			book.setBookTitle(bookTitle);
			book.setPublisher(publisher);
			oneService.makeBook(book);
		}
		
		Onesentence onesentence = new Onesentence();
		onesentence.setIsbn(isbn);
		onesentence.setOneSentence(oneSentence);
		onesentence.setPage(page);
		onesentence.setUserIdx(userIdx);
		
		oneService.upUserPoint(userIdx); //유저포인트 올려준다.
		
		oneService.makeOneSentence(onesentence);
		
		List<Onesentence> oneSentenceList = oneService.showOneSentenceList();
		model.addAttribute("oneSentenceList", oneSentenceList);
		
		return "onesentence/listAll";
	}
	
	@RequestMapping("/onesentence/list/all")
	public String selectOnesententceList(Model model) {
		List<Onesentence> oneSentenceList = oneService.showOneSentenceList();
		model.addAttribute("oneSentenceList", oneSentenceList);
		return "onesentence/listAll";
	}
	
	
	@RequestMapping("/onesentence/popup/{idx}")
	public String getUpdateForm(@PathVariable("idx") int idx, Model model) {
		Onesentence onesentence = oneService.showOneSentenceByoneSentenceIdx(idx);
		
		model.addAttribute("onesentence",onesentence);
		return "onesentence/popup";	
	}
	
	@RequestMapping("/onesentence/list/{idx}")
	public String selectOnesententceListByuserIdx(
			@PathVariable("idx") int idx,
			Model model) {		
		List<Onesentence> oneSentenceList = oneService.showOneSentenceListByuserIdx(idx);
		model.addAttribute("oneSentenceList", oneSentenceList);
		return "onesentence/listAll";
		
	}
	@RequestMapping("/onesentence/delete/{idx}")
	public String deleteOnesentenceByOnesentenceIdx(
			@PathVariable("idx") int idx,
			Model model) {	
		
		Onesentence onesentence = oneService.showOneSentenceByoneSentenceIdx(idx);
		int userIdx = onesentence.getUserIdx();
		oneService.downUserPoint(userIdx);
		
		System.out.println("delete"+idx);
		oneService.removeOneSentence(idx);
		
		
		
		List<Onesentence> oneSentenceList = oneService.showOneSentenceList();
		model.addAttribute("oneSentenceList", oneSentenceList);
		return "onesentence/listAll";
	}
	@RequestMapping("/onesentence/update")
	public String updateOnesentenceByOnesentenceIdx(Model model, HttpServletRequest request) {	
		System.out.println("update");
		String oneSentence = (String)request.getParameter("oneSentence");
		System.out.println("oneSentence"+oneSentence);
		
		String one = (String)request.getParameter("oneSentenceIdx");
		int oneSentenceIdx = Integer.parseInt(one);
		
		String page = (String)request.getParameter("page");
		int isbn = Integer.parseInt((String)request.getParameter("isbn"));
		
		System.out.println(oneSentenceIdx+";"+oneSentence+";"+isbn);
		
		oneService.changeOneSentence(oneSentenceIdx, oneSentence, page, isbn);
		
		return "onesentence/popupfinish";
	}
}
