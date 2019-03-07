package com.one.sentence.model;

public class Hashtag {
	private int hashtagIdx;
	private String hashtag;
	private int oneSentenceIdx;
	public int getHashtagIdx() {
		return hashtagIdx;
	}
	public void setHashtagIdx(int hashtagIdx) {
		this.hashtagIdx = hashtagIdx;
	}
	public String getHashtag() {
		return hashtag;
	}
	
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	public int getOneSentenceIdx() {
		return oneSentenceIdx;
	}
	public void setOneSentenceIdx(int oneSentenceIdx) {
		this.oneSentenceIdx = oneSentenceIdx;
	}
	@Override
	public String toString() {
		return "Hashtag [hashtagIdx=" + hashtagIdx + ", hashtag=" + hashtag + ", oneSentenceIdx=" + oneSentenceIdx
				+ "]";
	}
	
	
}
