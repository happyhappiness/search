package search.service.impl;

import java.util.List;

import javax.annotation.Resource;

import search.domain.Url;

import org.htmlparser.util.ParserException;
import org.springframework.stereotype.Service;

import search.service.SpiderService;
import search.service.UrlService;
import search.util.htmlParser.DoParser;


@Service
public class SpiderServiceImpl implements SpiderService{

	private DoParser parserHelper = new DoParser();
	
	@Resource
	private UrlService urlService = new UrlServiceImpl();
	private Url url = new Url();
		
	@Override
	public void storeUrl(List<String> urlList, List<String> pathList) {
		int n;
		n = pathList.size();
		String currPath;
		for( int i = 0; i < n; i++) {
			
			currPath = pathList.get(i);
			
			url.setUrl(urlList.get(i));
			url.setPath(currPath);
			url.setTitle(parserHelper.getTitle(currPath));
			url.setContent(parserHelper.getContent(currPath));
			//±£´æurl 
			urlService.saveOrUpdateUrl(url);
		}
				
	}

}
