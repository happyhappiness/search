package search.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import search.domain.Keyword;
import search.domain.Url;
import search.service.KeywordService;
import search.service.SearchService;
import search.service.UrlService;
import search.util.lucene.DoLucene;

@Service
public class SearchServiceImpl implements SearchService{

	private DoLucene luceneHelper;
	@Resource
	private KeywordService keywordService;
	@Resource
	private UrlService urlService;
	
	@Override
	@Transactional
	public List<Keyword> searchKeyword(String word) {
		//搜索缓存表
		List<Keyword> keywordList = keywordService.getKeywordByWord(word);
		
		//访问数据库，获取待索引的url对象
		List<Url> urlList = (ArrayList<Url>) urlService.getUrlByIndexed();
		for(Url url : urlList) {
    	    //更新url索引状态
    	    url.setIndexed(true);
    	    urlService.saveOrUpdateUrl(url);    	    
		}
		
		//调用lucene完成新的检索任务
		if(keywordList.size() == 0) {
			try {
				luceneHelper = new DoLucene(urlList);
				luceneHelper.query(word);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return keywordList;
	}

	//get and set
	public KeywordService getKeywordService() {
		return keywordService;
	}

	public void setKeywordService(KeywordService keywordService) {
		this.keywordService = keywordService;
	}
	
	public UrlService getUrlService() {
		return urlService;
	}

	public void setUrlService(UrlService urlService) {
		this.urlService = urlService;
	}


}
