package com.bitcamp.open0207.model;

public class Member2 {
	private int idx;
	private String id;
	private String email;
	private String password;
	private String name;
	
	public Member2() {}
	
	public Member2(int idx, String id, String email, String password, String name) {
		this.idx = idx;
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member2 [idx=" + idx + ", id=" + id + ", email=" + email + ", password=" + password + ", name=" + name
				+ "]";
	}
	
	

}
