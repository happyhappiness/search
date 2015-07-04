package search.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import search.domain.Keyword;

import org.springframework.stereotype.Repository;

import search.dao.BaseDAO;
import search.dao.KeywordDAO;

@Repository
public class KeywordDAOImpl extends BaseDAOImpl<Keyword> implements KeywordDAO{
	
	
	//删除指定keyword对象
	@Override
	public void deleteKeyword(Keyword keyword) {
		delete(keyword);
	}

	@Override
	public void attachDirtyKeyword(Keyword keyword) {
		attachDirty(keyword);
	}

	@Override
	public List<Keyword> findAllKeywords(Class<Keyword> keywordClass) {
		return findAll(keywordClass);
	}

	@Override
	public long findKeywordsCount(Class<Keyword> keywordClass) {
		return findCount(keywordClass);
	}

	@Override
	public List<Keyword> findKeywordByProperty(String propertyName, Object value) {
		return findByProperty(propertyName, value);
	}

	
}
