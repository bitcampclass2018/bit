package com.one.sentence.profile.dao;

import com.one.sentence.model.User_info;
import com.one.sentence.profile.model.Profile;

public interface IProfileDao {
	public User_info selectUser_infoByuserIdx(int userIdx);
	public int updateUser_info(int userIdx,String userPassword, String userName, String userIntroduction);
}
