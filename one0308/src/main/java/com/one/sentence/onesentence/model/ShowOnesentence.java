package com.one.sentence.onesentence.model;

import java.util.Date;

public class ShowOnesentence {
	private int userIdx; //출력은 안함
	private String userName;
	private int oneSentenceIdx;
	private String oneSentence;
	private String page;
	private Date oneSentenceRegisteredTime;
	private int isbn; //출력은 안함
	private String bookTitle;
	private String author;
	private String publisher; 
	
	public ShowOnesentence() {}
	
	public ShowOnesentence(int userIdx, String userName,int oneSentenceIdx, String oneSentence, String page,
			Date oneSentenceRegisteredTime, int isbn, String bookTitle, String author, String publisher) {
		this.userIdx = userIdx;
		this.userName = userName;
		this.oneSentenceIdx = oneSentenceIdx;
		this.oneSentence = oneSentence;
		this.page = page;
		this.oneSentenceRegisteredTime = oneSentenceRegisteredTime;
		this.isbn = isbn;
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOneSentence() {
		return oneSentence;
	}
	public void setOneSentence(String oneSentence) {
		this.oneSentence = oneSentence;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public Date getOneSentenceRegisteredTime() {
		return oneSentenceRegisteredTime;
	}
	public void setOneSentenceRegisteredTime(Date oneSentenceRegisteredTime) {
		this.oneSentenceRegisteredTime = oneSentenceRegisteredTime;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
	public int getOneSentenceIdx() {
		return oneSentenceIdx;
	}

	public void setOneSentenceIdx(int oneSentenceIdx) {
		this.oneSentenceIdx = oneSentenceIdx;
	}

	@Override
	public String toString() {
		return "ShowOnesentence [userIdx=" + userIdx + ", userName=" + userName + ", oneSentenceIdx=" + oneSentenceIdx
				+ ", oneSentence=" + oneSentence + ", page=" + page + ", oneSentenceRegisteredTime="
				+ oneSentenceRegisteredTime + ", isbn=" + isbn + ", bookTitle=" + bookTitle + ", author=" + author
				+ ", publisher=" + publisher + "]";
	}

	
	
	
}
