package search.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import search.dao.BaseDAO;
import search.dao.UrlDAO;
import search.domain.Url;

@Repository
public class UrlDAOImpl implements UrlDAO{

	@Resource
	private BaseDAO baseDAO = new BaseDAOImpl();
	
	//ɾ��url��Ϣ
	@Override
	public void deleteUrl(Url url){
		baseDAO.delete(url);
	}
   
	//��ӻ����url 
	@Override
	public void attachDirtyUrl(Url url){
		baseDAO.attachDirty(url);
	}
	
	//��ȡȫ�������Ϣ
    public List<Url> findAllUrls(Class<Url> urlClass){
    	return baseDAO.findAll(urlClass);
    }
    
    public long findUrlsCount(Class<Url> urlClass){
    	return baseDAO.findCount(urlClass);
    }
    
    //��������ֵ��ȡ����   
    public List<Url> findUrlByProperty(String propertyName, Object value) {
    	return baseDAO.findByProperty(propertyName, value);
    }

}
