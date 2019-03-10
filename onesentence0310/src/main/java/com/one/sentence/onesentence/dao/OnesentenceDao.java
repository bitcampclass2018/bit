package com.one.sentence.onesentence.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.one.sentence.model.Hashtag;
import com.one.sentence.model.Onesentence;
import com.one.sentence.onesentence.model.Book;
import com.one.sentence.onesentence.model.ShowOnesentence;

 
@Repository
public class OnesentenceDao implements IOnesentenceDao{

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.Mapper";
	
	@Override
	public int insertOneSentence(Onesentence onesentence) {
		return sqlSession.insert(namespace+".insertOnesentence", onesentence);
	}

	@Override
	public List<ShowOnesentence> selectOnesentenceList() {
		return sqlSession.selectList(namespace+".selectOnesentenceList");
	}

	@Override
	public List<ShowOnesentence> selectOnesentenceListByuserIdx(int userIdx) {
		return sqlSession.selectList(namespace+".selectOnesentenceListByuserIdx",userIdx);
	}
	
	@Override
	public List<ShowOnesentence> selectOnesentenceListForLiketo(int userIdx) {
		return sqlSession.selectList(namespace+".selectOnesentenceForliketo",userIdx);
	}
	
	@Override
	public int updateOneSentence(int oneSentenceIdx,String oneSentence, String page, int isbn) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("oneSentenceIdx", oneSentenceIdx);
		map.put("oneSentence", oneSentence);
		map.put("page", page);
		map.put("isbn", isbn);
		return sqlSession.update(namespace+".updateOnesentence", map);
	}

	@Override
	public int deleteOnesentence(int oneSentenceIdx) {
		return sqlSession.delete(namespace+".deleteOnesentence",oneSentenceIdx);
	}

	@Override
	public ShowOnesentence selectOnesentenceByoneSentenceIdx(int oneSentenceIdx) {
		return sqlSession.selectOne(namespace+".selectOnesentenceByoneSentenceIdx", oneSentenceIdx);
	}
	@Override
	public Onesentence selectOnesentenceModel(int oneSentenceIdx) {
		return sqlSession.selectOne(namespace+".selectOnesentenceModel", oneSentenceIdx);
	}

	@Override
	public int insertBook(Book book) {
		return sqlSession.insert(namespace+".insertBook",book);
	}

	@Override
	public Book selectBookByisbn(int isbn) {
		return sqlSession.selectOne(namespace+".selectBookByisbn",isbn);
	}

	@Override
	public int upUserPoint(int userIdx) {
		return sqlSession.update(namespace+".upUserPoint", userIdx);
	}

	@Override
	public int downUserPoint(int userIdx) {
		return sqlSession.update(namespace+".downUserPoint", userIdx);
	}

	@Override
	public int insertHashtag(Hashtag tag) {
		return sqlSession.insert(namespace+".insertHashtag", tag);
	}
	
	public int findOneSentenceIdx(int userIdx, int isbn, String oneSentence) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userIdx", userIdx);
		map.put("isbn", isbn);
		map.put("oneSentence", oneSentence);
		return sqlSession.selectOne(namespace+".findOneSentenceIdx", map);
	}

	
}
