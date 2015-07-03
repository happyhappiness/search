package search.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import search.domain.Url;

@Repository
public interface UrlDAO {

	//删除url信息
	void deleteUrl(Url url);
   
	//添加或更新url 
	void attachDirtyUrl(Url url);
	
	//获取全体对象信息
    List<Url> findAllUrls(Class<Url> urlClass);
    long findUrlsCount(Class<Url> urlClass);
    
    //根据属性值获取对象   
    List<Url> findUrlByProperty(String propertyName, Object value);

}
