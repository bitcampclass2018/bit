package com.one.sentence.onesentence.dao;


import java.util.List;

import com.one.sentence.onesentence.model.Book;
import com.one.sentence.onesentence.model.Onesentence;

public interface IOnesentenceDao {

	public int insertOneSentence(Onesentence onesentence);
	public List<Onesentence> selectOnesentenceList();
	public List<Onesentence> selectOnesentenceListByuserIdx(int userIdx);
	public Onesentence selectOnesentenceByoneSentenceIdx(int oneSentenceIdx);
	public int updateOneSentence(int oneSentenceIdx,String oneSentence, String page, int isbn);
	public int deleteOnesentence(int oneSentenceIdx);
	
	public int insertBook(Book book);
	public Book selectBookByisbn(int isbn);
	
	public int upUserPoint(int userIdx);
	public int downUserPoint(int userIdx);
}
