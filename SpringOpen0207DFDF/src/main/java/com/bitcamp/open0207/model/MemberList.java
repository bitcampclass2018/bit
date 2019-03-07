package com.bitcamp.open0207.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class MemberList {
	
	private List<Member> memlist;
	
	public MemberList() {}
	
	public MemberList(List<Member> memlist) {
		this.memlist = memlist;
	}
	public List<Member> getMemlist(){
		return memlist;
	}
}
