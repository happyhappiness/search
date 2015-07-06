package search.dao;

import java.util.List;



import org.springframework.stereotype.Repository;

import search.domain.Url;

@Repository
public interface UrlDAO {


	
	//删除url信息
	void deleteUrl(Url url);
   
	//添加或更新url 
	void attachDirtyUrl(Url url);
	
	//获取全体对象信息
    List<Url> findAllUrls();
    long findUrlsCount();
    
    //根据id获取url对象
	List<Url> getUrlByUid(int uid);
	
	//根据url获取url对象
	List<Url> getUrlByUrl(String url);
	
    //根据属性值获取对象   
    List<Url> findUrlByProperty(String propertyName, Object value);
    

    //根据example获取url
    List<Url> findUrlByExample(Url url);
}
