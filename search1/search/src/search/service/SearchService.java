package search.service;

import java.util.List;

import search.domain.Url;

public interface SearchService {

	//更新索引表
	void updateIndex();
	
	//根据关键词搜索
	List<Url> searchKeyword(String word);
}
