package search.dao;

import java.util.List;

import search.domain.Keyword;

import org.springframework.stereotype.Repository;

import search.domain.Url;

@Repository
public interface KeywordDAO {

	//删除keyword信息
	void deleteKeyword(Keyword keyword);
   
	//添加或更新keyword 
	void attachDirtyKeyword(Keyword keyword);
	
	//获取全体keyword对象信息
    List<Keyword> findAllKeywords();
    long findKeywordsCount();
    
    //根据属性值获取keyword对象   
    List<Keyword> findKeywordByProperty(String propertyName, Object value);
    

	//根据关键字内容获取对象
	List<Keyword> getKeywordByWord(String word);
	
	
    //根据example获取keyword对象（考虑关联）
    List<Keyword> findKeywordByExample(Keyword keyword);
    
    //删除所有缓存记录
    void deleteAll();
}
