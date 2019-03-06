package com.bitcamp.open0207.model;

public class Board {
	private int idx;
	private String member_id;
	private String password;
	private String message;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Board [idx=" + idx + ", member_id=" + member_id + ", password=" + password + ", message=" + message
				+ "]";
	}
	
	
}
