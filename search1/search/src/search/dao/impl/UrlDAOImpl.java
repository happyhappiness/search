package search.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import search.dao.BaseDAO;
import search.dao.UrlDAO;
import search.domain.Url;

@Repository
public class UrlDAOImpl extends BaseDAOImpl<Url> implements UrlDAO{

	
	//ɾ��url��Ϣ
	@Override
	public void deleteUrl(Url url){
		delete(url);
	}
   
	//��ӻ����url 
	@Override
	public void attachDirtyUrl(Url url){
		attachDirty(url);
	}
	
	//��ȡȫ�������Ϣ
    public List<Url> findAllUrls(Class<Url> urlClass){
    	return findAll(urlClass);
    }
    
    public long findUrlsCount(Class<Url> urlClass){
    	return findCount(urlClass);
    }
    
    //��������ֵ��ȡ����   
    public List<Url> findUrlByProperty(String propertyName, Object value) {
    	return findByProperty(propertyName, value);
    }

}
