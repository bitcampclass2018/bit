package com.one.sentence.profile.service;

import com.one.sentence.model.User_info;

public interface IProfileService {
	public User_info showUser_infoByuserIdx(int userIdx);
	public void changeUser_info(int userIdx,String userPassword, String userName, String userIntroduction);
	
}
