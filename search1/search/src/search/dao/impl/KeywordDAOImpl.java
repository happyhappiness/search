package search.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import search.domain.Keyword;

import org.hibernate.Query;
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
		//根据example获取keyword对象
		List<Keyword> keywordList = findByExample(keyword);
		if(keywordList != null && keywordList.size() != 0) {
			Keyword tempKeyword = keywordList.get(0);
			attachDirty(tempKeyword);
		}
		else{
			attachDirty(keyword);
		}
	}

	@Override
	public List<Keyword> findAllKeywords() {
		return findAll(Keyword.class);
	}

	@Override
	public long findKeywordsCount() {
		return findCount(Keyword.class);
	}

	@Override
	public List<Keyword> findKeywordByProperty(String propertyName, Object value) {
		return findByProperty(propertyName, value);
	}
	
	//根据关键字内容获取关键字对象
	@Override
	public List<Keyword> getKeywordByWord(String word) {
		return findByProperty("word", word);
	}


	//根据example的word值和uid值获取keyword对象
	@Override
	public List<Keyword> findKeywordByExample(Keyword keyword) {
		
		Query query = getSessionFactory().getCurrentSession()
        .createQuery("from Keyword where word = ? and uid = ?");
		query.setString(0, keyword.getWord());
		query.setInteger(1, keyword.getUid());		
		return query.list();
	}

	//删除所有缓存信息
	@Override
	public void deleteAll() {
		getSessionFactory().getCurrentSession()
		        .createQuery("delete from Keyword where 1 = 1")
		        .executeUpdate();
	}

	
}
