package search.service;

import java.util.List;

import org.springframework.stereotype.Service;

import search.domain.Url;

@Service
public interface UrlService {
	
	//根据path获取url
	List<Url> getUrlByPath(String path);
	
	//根据keyword获取url
	List<Url> getUrlByKeyword(String keyword);
	
	//获取所有url
	List<Url> getUrlByIndexed();
	
	//删除url
	void delteUrlByProperty(String propertyName, Object value);
	
	//保存url
	void saveOrUpdateUrl(Url url);

}
