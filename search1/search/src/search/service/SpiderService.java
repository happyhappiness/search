package search.service;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface SpiderService {

	//heritix接口获取url信息
	List<String> getUrlList();
	
	//heritix接口获取path信息
	List<String> getPathList();
		
	//根据url信息和path信息生成并存储url对象
	void storeUrl(List<String> urlList, List<String> pathList);
	
	//删除缓存表
	void clearCache();
/*	//根据url信息生成并存储url对象
	void storeUrl(List<String> urlList);*/
}
