package com.one.sentence.onesentence.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.one.sentence.onesentence.dao.OnesentenceDao;
import com.one.sentence.onesentence.model.Book;
import com.one.sentence.onesentence.model.Onesentence;

@Service
public class OnesentenceService implements IOnesentenceService {

	@Inject
	private OnesentenceDao dao;
	
	@Override
	public void makeOneSentence(Onesentence onesentence) {
		dao.insertOneSentence(onesentence);
	}

	@Override
	public List<Onesentence> showOneSentenceList() {
		return dao.selectOnesentenceList();
		
	}

	@Override
	public List<Onesentence> showOneSentenceListByuserIdx(int userIdx) {
		return dao.selectOnesentenceListByuserIdx(userIdx);
		
	}

	@Override
	public Onesentence showOneSentenceByoneSentenceIdx(int oneSentenceIdx) {
		return dao.selectOnesentenceByoneSentenceIdx(oneSentenceIdx);
	}

	@Override
	public void changeOneSentence(int oneSentenceIdx,String oneSentence, String page, int isbn) {
		System.out.println(isbn);
	
		dao.updateOneSentence(oneSentenceIdx,oneSentence,page,isbn);
		
	}

	@Override
	public int removeOneSentence(int oneSentenceIdx) {
		System.out.println("del_service호출");
		return dao.deleteOnesentence(oneSentenceIdx);
		
	}

	@Override
	public void makeBook(Book book) {
		dao.insertBook(book);
		
	}

	@Override
	public Book showBookByisbn(int isbn) {
		return dao.selectBookByisbn(isbn);
	}

	@Override
	public void upUserPoint(int userIdx) {
		dao.upUserPoint(userIdx);
		
	}

	@Override
	public void downUserPoint(int userIdx) {
		dao.downUserPoint(userIdx);
		
	}

	

}
