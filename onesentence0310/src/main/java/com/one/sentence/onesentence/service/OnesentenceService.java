package com.one.sentence.onesentence.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.one.sentence.model.Hashtag;
import com.one.sentence.model.Onesentence;
import com.one.sentence.onesentence.dao.OnesentenceDao;
import com.one.sentence.onesentence.model.Book;
import com.one.sentence.onesentence.model.ShowOnesentence;

@Service
public class OnesentenceService implements IOnesentenceService {

	@Inject
	private OnesentenceDao dao;
	
	@Override
	public void makeOneSentence(Onesentence onesentence) {
		dao.insertOneSentence(onesentence);
	}
 
	@Override
	public List<ShowOnesentence> showOneSentenceList() {
		return dao.selectOnesentenceList();
		
	}

	@Override
	public List<ShowOnesentence> showOneSentenceListByuserIdx(int userIdx) {
		return dao.selectOnesentenceListByuserIdx(userIdx);
		
	}

	
	@Override
	public List<ShowOnesentence> showOneSentenceListForLiketo(int userIdx) {
		return dao.selectOnesentenceListForLiketo(userIdx);
		
	}
	
	@Override
	public ShowOnesentence showOneSentenceByoneSentenceIdx(int oneSentenceIdx) {
		return dao.selectOnesentenceByoneSentenceIdx(oneSentenceIdx);
	}
	@Override
	public Onesentence showOneSentenceModel(int oneSentenceIdx) {
		return dao.selectOnesentenceModel(oneSentenceIdx);
	}

	@Override
	public void changeOneSentence(int oneSentenceIdx,String oneSentence, String page, int isbn) {
		System.out.println(isbn);
	
		dao.updateOneSentence(oneSentenceIdx,oneSentence,page,isbn);
		
	}

	@Override
	public int removeOneSentence(int oneSentenceIdx) {
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

	@Override
	public void makeHashtag(Hashtag tag) {
		dao.insertHashtag(tag);
		
	}

	@Override
	public int findOneSentenceIdx(int userIdx, int isbn, String oneSentence) {
		return dao.findOneSentenceIdx(userIdx, isbn, oneSentence);
	}

}
