package search.service.impl;

import java.util.List;

import javax.annotation.Resource;

import search.domain.Url;

import org.htmlparser.util.ParserException;
import org.springframework.stereotype.Service;

import search.service.SpiderService;
import search.service.UrlService;
import search.util.heritix.DoHeritix;
import search.util.htmlParser.DoParser;
import search.util.htmlParser.DoParserOffLine;
import search.util.htmlParser.DoParserOnLine;


@Service
public class SpiderServiceImpl implements SpiderService{

	private DoParser parserHelper;
	private DoHeritix heritixHelper;
	private final String URL_FILE_PATH = "e:\\url.txt";
	//TODO
	private final String PATH_FILE_PATH = "e:\\url.txt";
	
	@Resource
	private UrlService urlService = new UrlServiceImpl();
	private Url url = new Url();
	
	//heritix接口：获取urlList信息
	@Override
	public List<String> getUrlList() {
		
		heritixHelper = new DoHeritix();
		return heritixHelper.getUrl(URL_FILE_PATH);
	}
	
	//heritix接口：获取pathList信息
	@Override
	public List<String> getPathList() {
		
		heritixHelper = new DoHeritix();
		return heritixHelper.getUrl(PATH_FILE_PATH);
	}
	
	//借助DoParserOffLine从url和path中获取url对象并存储
	@Override
	public void storeUrl(List<String> urlList, List<String> pathList) {
		
		parserHelper = new DoParserOffLine();
		
		int n;
		n = urlList.size();
		String currPath;
		for( int i = 0; i < n; i++) {
			
			currPath = pathList.get(i);
			
			url.setUrl(urlList.get(i));
			url.setPath(currPath);
			url.setTitle(parserHelper.getTitle(currPath));
			url.setContent(parserHelper.getContent(currPath));
			url.setIndexed(false);
			//保存url 
			urlService.saveOrUpdateUrl(url);
		}
		
		System.out.println("STORE URL !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				
	}

	//借助DoParserOnLine从url获取url对象并存储
	@Override
	public void storeUrl(List<String> urlList) {
		parserHelper = new DoParserOnLine();
		int n;
		n = urlList.size();
		String currUrl;
		for( int i = 0; i < n; i++) {
			currUrl = urlList.get(i);
			
			url.setUrl(urlList.get(i));
			url.setPath(null);
			url.setTitle(parserHelper.getTitle(currUrl));
			url.setContent(parserHelper.getContent(currUrl));
			url.setIndexed(false);
			//保存url 
			urlService.saveOrUpdateUrl(url);
		}
		
		System.out.println("STORE URL !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}


}
