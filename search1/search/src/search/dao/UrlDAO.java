package search.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import search.domain.Url;

@Repository
public interface UrlDAO {

	//ɾ��url��Ϣ
	void deleteUrl(Url url);
   
	//��ӻ����url 
	void attachDirtyUrl(Url url);
	
	//��ȡȫ�������Ϣ
    List<Url> findAllUrls(Class<Url> urlClass);
    long findUrlsCount(Class<Url> urlClass);
    
    //��������ֵ��ȡ����   
    List<Url> findUrlByProperty(String propertyName, Object value);

}
