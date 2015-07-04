package search.dao;

import java.util.List;

import javassist.compiler.ast.Keyword;

import org.springframework.stereotype.Repository;

import search.domain.Url;

@Repository
public interface KeywordDAO {

	//删除keyword信息
	void deleteKeyword(Keyword keyword);
   
	//添加或更新keyword 
	void attachDirtyKeyword(Keyword keyword);
	
	//获取全体keyword对象信息
    List<Keyword> findAllKeywords(Class<Keyword> keywordClass);
    long findKeywordsCount(Class<Keyword> keywordClass);
    
    //根据属性值获取keyword对象   
    List<Keyword> findKeywordByProperty(String propertyName, Object value);
}
