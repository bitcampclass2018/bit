package com.one.sentence.onesentence.service;

import java.util.List;

import com.one.sentence.onesentence.model.Book;
import com.one.sentence.onesentence.model.Onesentence;

public interface IOnesentenceService {
	public void makeOneSentence(Onesentence onesentence);
	public List<Onesentence> showOneSentenceList();
	public List<Onesentence> showOneSentenceListByuserIdx(int userIdx);
	public Onesentence showOneSentenceByoneSentenceIdx(int oneSentenceIdx);
	public void changeOneSentence(int oneSentenceIdx, String oneSentence, String page, int isbn);
	public int removeOneSentence(int oneSentenceIdx);
	
	public void makeBook(Book book);
	public Book showBookByisbn(int isbn);
	
	public void upUserPoint(int userIdx);
	public void downUserPoint(int userIdx);
}
