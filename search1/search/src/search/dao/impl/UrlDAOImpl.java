package search.dao.impl;

import java.util.List;



import org.springframework.stereotype.Repository;

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
		//根据实体查询Url表
		List<Url> urlList = findByExample(url);
		if(urlList != null && urlList.size() != 0) {
			Url tempUrl = urlList.get(0);
			url.setUid(tempUrl.getUid());
		}
		attachDirty(url);
	}
	
	//获取全体对象信息
    public List<Url> findAllUrls(){
    	return findAll(Url.class);
    }
    
    public long findUrlsCount(){
    	return findCount(Url.class);
    }
    
	//根据主键获取url对象
	@Override
	public List<Url> getUrlByUid(int uid) {
		return findByProperty("uid", uid);
	}


	//根据url获取url对象
	@Override
	public List<Url> getUrlByUrl(String url) {
		
		return findByProperty("url", url);
	}
	
    //根据属性值获取对象   
    public List<Url> findUrlByProperty(String propertyName, Object value) {
    	return findByProperty(propertyName, value);
    }

    //根据example获取对象
	@Override
	public List<Url> findUrlByExample(Url url) {
		return findByExample(url);	
	}

}
