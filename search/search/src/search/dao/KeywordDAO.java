package search.dao;

import java.util.List;

import javassist.compiler.ast.Keyword;

import org.springframework.stereotype.Repository;

import search.domain.Url;

@Repository
public interface KeywordDAO {

	//ɾ��keyword��Ϣ
	void deleteKeyword(Keyword keyword);
   
	//��ӻ����keyword 
	void attachDirtyKeyword(Keyword keyword);
	
	//��ȡȫ��keyword������Ϣ
    List<Keyword> findAllKeywords(Class<Keyword> keywordClass);
    long findKeywordsCount(Class<Keyword> keywordClass);
    
    //��������ֵ��ȡkeyword����   
    List<Keyword> findKeywordByProperty(String propertyName, Object value);
}
