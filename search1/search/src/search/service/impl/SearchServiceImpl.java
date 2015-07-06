package search.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import search.dao.KeywordDAO;
import search.dao.UrlDAO;
import search.domain.Keyword;
import search.domain.Url;
import search.service.SearchService;
import search.util.lucene.DoLucene;

@Service
public class SearchServiceImpl implements SearchService{

	private DoLucene luceneHelper = new DoLucene();
	@Resource
	private KeywordDAO keywordDAO;
	@Resource
	private UrlDAO urlDAO;
	@Resource
	private Keyword keyword;
	

	//创建索引表
	@Override
	public void updateIndex() {
			
		List<Url> urlList = urlDAO.findAllUrls();
		try {
			luceneHelper.createIndex(urlList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	//搜索关键字
	@Override
	@Transactional
	public List<Url> searchKeyword(String word) {
		
		//查询缓存表:存在则不搜索索引表
		List<Keyword> keywordList = keywordDAO.findKeywordByProperty("word", word);
		List<Url> urlList = new ArrayList<Url>();
		
		if(keywordList != null & keywordList.size() != 0){
			
			for(Keyword keyword : keywordList){
				urlList.add((urlDAO.getUrlByUid(keyword.getUid())).get(0));
			}		
			
			return urlList;
		}
		
		//搜索索引表
	    try {
			List<String> urlNameList = luceneHelper.query(word);

			urlList.clear();
			for(String urlName : urlNameList) {
				urlList.add(urlDAO.getUrlByUrl(urlName).get(0));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		//更新keyword缓存表
		for(Url url : urlList){
			keyword = new Keyword();
			keyword.setWord(word);
			keyword.setUid(url.getUid());
			keywordDAO.attachDirtyKeyword(keyword);
		}
		
		return urlList;		
	}

	//get and set

	public Keyword getKeyword() {
		return keyword;
	}

	public KeywordDAO getKeywordDAO() {
		return keywordDAO;
	}

	public void setKeywordDAO(KeywordDAO keywordDAO) {
		this.keywordDAO = keywordDAO;
	}

	public UrlDAO getUrlDAO() {
		return urlDAO;
	}

	public void setUrlDAO(UrlDAO urlDAO) {
		this.urlDAO = urlDAO;
	}

	public void setKeyword(Keyword keyword) {
		this.keyword = keyword;
	}


}
