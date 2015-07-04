package search.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import search.dao.BaseDAO;
import search.dao.UrlDAO;
import search.domain.Url;

@Repository
public class UrlDAOImpl extends BaseDAOImpl<Url> implements UrlDAO{

	
	//删除url信息
	@Override
	public void deleteUrl(Url url){
		delete(url);
	}
   
	//添加或更新url 
	@Override
	public void attachDirtyUrl(Url url){
		attachDirty(url);
	}
	
	//获取全体对象信息
    public List<Url> findAllUrls(Class<Url> urlClass){
    	return findAll(urlClass);
    }
    
    public long findUrlsCount(Class<Url> urlClass){
    	return findCount(urlClass);
    }
    
    //根据属性值获取对象   
    public List<Url> findUrlByProperty(String propertyName, Object value) {
    	return findByProperty(propertyName, value);
    }

}
