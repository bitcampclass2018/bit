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

import com.one.sentence.model.Hashtag;
import com.one.sentence.model.Onesentence;
import com.one.sentence.onesentence.model.Book;
import com.one.sentence.onesentence.model.ShowOnesentence;
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
			@RequestParam("hashtag") String hashtag,
			Model model
			) {

		System.out.println(isbn+":"+page+":"+oneSentence+":"+userIdx);
		
		if(oneService.showBookByisbn(isbn)==null) {
			
			Book book = new Book();
			//String author = request.getParameter("author");
			String author = "沅뚯옱吏�";
			String bookGenre = "怨듯룷�냼�꽕";
			String bookTitle = "�븳吏�誘�";
			String publisher = "鍮꾪듃異쒗뙋�궗";
			
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
		
		oneService.upUserPoint(userIdx); //�쑀���룷�씤�듃 �삱�젮以��떎.
		
		oneService.makeOneSentence(onesentence);
		
		
		//0출력; 한문장 idx값을 어떻게 받
		int oneSentenceIdx = oneService.findOneSentenceIdx(userIdx, isbn, oneSentence);
		System.out.println("---"+oneSentenceIdx);
		
		Hashtag tag = new Hashtag();
		tag.setHashtag(hashtag);
		tag.setOneSentenceIdx(oneSentenceIdx);
		
		oneService.makeHashtag(tag);
		
		List<ShowOnesentence> oneSentenceList = oneService.showOneSentenceList();
		model.addAttribute("oneSentenceList", oneSentenceList);
		
		return "onesentence/list";
	}
	
	@RequestMapping("/onesentence/list/all")
	public String selectOnesententceList(Model model) {
		List<ShowOnesentence> oneSentenceList = oneService.showOneSentenceList();
		model.addAttribute("oneSentenceList", oneSentenceList);
		return "onesentence/list";
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
		List<ShowOnesentence> oneSentenceList = oneService.showOneSentenceListByuserIdx(idx);
		model.addAttribute("oneSentenceList", oneSentenceList);
		return "onesentence/list";
		
	}
	@RequestMapping("/onesentence/liketo/{idx}")
	public String selectOnesententceListForLiketo(
			@PathVariable("idx") int idx,
			Model model) {		
		List<ShowOnesentence> oneSentenceList = oneService.showOneSentenceListForLiketo(idx);
		
		model.addAttribute("oneSentenceList", oneSentenceList);
		return "onesentence/list";
		
	}
	@RequestMapping("/onesentence/delete/{idx}")
	public String deleteOnesentenceByOnesentenceIdx(
			@PathVariable("idx") int idx,
			Model model) {	
		
		Onesentence onesentence = oneService.showOneSentenceByoneSentenceIdx(idx);
		int userIdx = onesentence.getUserIdx();
		oneService.downUserPoint(userIdx);
		
		oneService.removeOneSentence(idx);
		
		
		
		List<ShowOnesentence> oneSentenceList = oneService.showOneSentenceList();
		model.addAttribute("oneSentenceList", oneSentenceList);
		return "onesentence/list";
	}
	@RequestMapping("/onesentence/update")
	public String updateOnesentenceByOnesentenceIdx(Model model, HttpServletRequest request) {	
		String oneSentence = (String)request.getParameter("oneSentence");
		
		String one = (String)request.getParameter("oneSentenceIdx");
		int oneSentenceIdx = Integer.parseInt(one);
		
		String page = (String)request.getParameter("page");
		int isbn = Integer.parseInt((String)request.getParameter("isbn"));

		oneService.changeOneSentence(oneSentenceIdx, oneSentence, page, isbn);
		
		return "onesentence/popupfinish";
	}
}
