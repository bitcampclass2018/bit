package com.one.sentence.profile.model;

public class Profile {
	private int userIdx;
	private String userName;
	private int userPoint;
	private String userIntroduction;
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	public String getUserIntroduction() {
		return userIntroduction;
	}
	public void setUserIntroduction(String userIntroduction) {
		this.userIntroduction = userIntroduction;
	}
	@Override
	public String toString() {
		return "Profile [userIdx=" + userIdx + ", userName=" + userName + ", userPoint=" + userPoint
				+ ", userIntroduction=" + userIntroduction + "]";
	}
}
