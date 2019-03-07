package com.one.sentence.onesentence.service;

import java.util.List;

import com.one.sentence.model.Hashtag;
import com.one.sentence.model.Onesentence;
import com.one.sentence.onesentence.model.Book;
import com.one.sentence.onesentence.model.ShowOnesentence;

public interface IOnesentenceService {
	public void makeOneSentence(Onesentence onesentence);
	public List<ShowOnesentence> showOneSentenceList();
	public List<ShowOnesentence> showOneSentenceListByuserIdx(int userIdx);
	public List<ShowOnesentence> showOneSentenceListForLiketo(int userIdx); 
	public ShowOnesentence showOneSentenceByoneSentenceIdx(int oneSentenceIdx);
	public Onesentence showOneSentenceModel(int oneSentenceIdx);
	public void changeOneSentence(int oneSentenceIdx, String oneSentence, String page, int isbn);
	public int removeOneSentence(int oneSentenceIdx);
	
	public void makeBook(Book book); 
	public Book showBookByisbn(int isbn);
	
	public void upUserPoint(int userIdx);
	public void downUserPoint(int userIdx);
	
	public void makeHashtag(Hashtag tag);
	public int findOneSentenceIdx(int userIdx, int isbn, String oneSentence);
	
}
