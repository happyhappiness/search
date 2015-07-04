package search.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import javassist.compiler.ast.Keyword;

import org.springframework.stereotype.Repository;

import search.dao.BaseDAO;
import search.dao.KeywordDAO;
import search.domain.Url;

@Repository
public class KeywordDAOImpl implements KeywordDAO{

	@Resource
	private BaseDAO baseDAO = new BaseDAOImpl();
	
	//删除指定keyword对象
	@Override
	public void deleteKeyword(Keyword keyword) {
		baseDAO.delete(keyword);
	}

	@Override
	public void attachDirtyKeyword(Keyword keyword) {
		baseDAO.attachDirty(keyword);
	}

	@Override
	public List<Keyword> findAllKeywords(Class<Keyword> keywordClass) {
		return baseDAO.findAll(keywordClass);
	}

	@Override
	public long findKeywordsCount(Class<Keyword> keywordClass) {
		return baseDAO.findCount(keywordClass);
	}

	@Override
	public List<Keyword> findKeywordByProperty(String propertyName, Object value) {
		return baseDAO.findByProperty(propertyName, value);
	}

	
}
