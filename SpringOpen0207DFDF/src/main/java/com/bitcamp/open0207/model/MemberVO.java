package com.bitcamp.open0207.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	private int idx;
	private String id;
	private String email;
	private String password;
	private String name;
	
	public int getIdx() {
		return idx;
	}
	public String getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	
	
}
