package search.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import search.domain.Keyword;
import search.service.KeywordService;
import search.service.SearchService;
import search.util.lucene.Lucene;

@Service
public class SearchServiceImpl implements SearchService{

	private Lucene luceneHelper;
	@Resource
	private KeywordService keywordService = new KeywordServiceImpl();
	
	@Override
	public List<Keyword> searchKeyword(String word) {
		//搜索缓存表
		List<Keyword> keywordList = keywordService.getKeywordByWord(word);
		
		//调用lucene索引
		if(keywordList.size() == 0) {
			try {
				luceneHelper = new Lucene();
				luceneHelper.query(word);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return keywordList;
	}

}
