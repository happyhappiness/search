package search.dao;

import java.util.List;

import search.domain.Keyword;

import org.springframework.stereotype.Repository;

import search.domain.Url;

@Repository
public interface KeywordDAO {

	//ɾ��keyword��Ϣ
	void deleteKeyword(Keyword keyword);
   
	//��ӻ����keyword 
	void attachDirtyKeyword(Keyword keyword);
	
	//��ȡȫ��keyword������Ϣ
    List<Keyword> findAllKeywords();
    long findKeywordsCount();
    
    //��������ֵ��ȡkeyword����   
    List<Keyword> findKeywordByProperty(String propertyName, Object value);
    

	//���ݹؼ������ݻ�ȡ����
	List<Keyword> getKeywordByWord(String word);
	
	
    //����example��ȡkeyword���󣨿��ǹ�����
    List<Keyword> findKeywordByExample(Keyword keyword);
    
    //ɾ�����л����¼
    void deleteAll();
}
