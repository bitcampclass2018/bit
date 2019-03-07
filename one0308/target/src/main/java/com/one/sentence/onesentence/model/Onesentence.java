package com.one.sentence.onesentence.model;

import java.util.Date;

public class Onesentence {
	private int oneSentenceIdx;
	private String oneSentence;
	private String page;
	private Date oneSentenceRegisteredTime;
	private int userIdx;
	private int isbn;
	
	
	public Onesentence() {}
	
	public Onesentence(int oneSentenceIdx, String oneSentence, String page, Date oneSentenceRegisteredTime, int userIdx,
			int isbn) {
		this.oneSentenceIdx = oneSentenceIdx;
		this.oneSentence = oneSentence;
		this.page = page;
		this.oneSentenceRegisteredTime = oneSentenceRegisteredTime;
		this.userIdx = userIdx;
		this.isbn = isbn;
	}
	public int getOneSentenceIdx() {
		return oneSentenceIdx;
	}
	public void setOneSentenceIdx(int oneSentenceIdx) {
		this.oneSentenceIdx = oneSentenceIdx;
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
	@Override
	public String toString() {
		return "Onesentence [oneSentenceIdx=" + oneSentenceIdx + ", oneSentence=" + oneSentence + ", page=" + page
				+ ", oneSentenceRegisteredTime=" + oneSentenceRegisteredTime + ", userIdx=" + userIdx + ", isbn=" + isbn
				+ "]";
	}
	
	
}
