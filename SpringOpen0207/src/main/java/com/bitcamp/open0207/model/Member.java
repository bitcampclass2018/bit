package com.bitcamp.open0207.model;

public class Member {
	private int idx;
	private String id;
	private String email;
	private String password;
	private String name;
	private String photo;
	private String ckcode;
	private int sit;
	
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	public String getCkcode() {
		return ckcode;
	}
	public void setCkcode(String ckcode) {
		this.ckcode = ckcode;
	}
	public int getSit() {
		return sit;
	}
	public void setSit(int sit) {
		this.sit = sit;
	}
	@Override
	public String toString() {
		return "Member [idx=" + idx + ", id=" + id + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", photo=" + photo + ", ckcode=" + ckcode + ", sit=" + sit + "]";
	}
	

}
