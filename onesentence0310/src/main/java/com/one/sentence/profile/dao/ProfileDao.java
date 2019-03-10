package com.one.sentence.profile.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.one.sentence.model.User_info;


@Repository
public class ProfileDao implements IProfileDao {

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.Mapper";
	

	@Override
	public int updateUser_info(int userIdx, String userPassword, String userName, String userIntroduction) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userIdx", userIdx);
		map.put("userPassword", userPassword);
		map.put("userName", userName);
		map.put("userIntroduction", userIntroduction);
		return sqlSession.update(namespace+".updateUser_info", map);
	}

	@Override
	public User_info selectUser_infoByuserIdx(int userIdx) {
		return sqlSession.selectOne(namespace+".selectUser_infoByuserIdx", userIdx);
	}

}
