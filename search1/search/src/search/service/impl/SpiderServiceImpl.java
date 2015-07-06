package search.service.impl;

import java.util.List;

import javax.annotation.Resource;

import search.dao.KeywordDAO;
import search.dao.UrlDAO;
import search.domain.Url;

import org.springframework.stereotype.Service;

import search.service.SpiderService;
import search.util.heritix.DoHeritix;
import search.util.htmlParser.DoParser;


@Service
public class SpiderServiceImpl implements SpiderService{

	private DoParser parserHelper = new DoParser();
	private DoHeritix heritixHelper;
	
	@Resource
	private UrlDAO urlDAO;
	@Resource 
	private KeywordDAO keywordDAO;
	@Resource
	private Url url;
	
	//heritix接口：获取urlList信息
	@Override
	public List<String> getUrlList() {
		
		heritixHelper = new DoHeritix();
		return heritixHelper.getUrl();
	}


	//heritix接口：获取pathList信息
	@Override
	public List<String> getPathList() {
		
		heritixHelper = new DoHeritix();
		return heritixHelper.getPath();
	}
	
	//借助DoParserOffLine从url和path中获取url对象并存储
	@Override
	public void storeUrl(List<String> urlList, List<String> pathList) {
		
		//List<Url> currUrlList;
		
		int n;
		n = urlList.size();
		String currPath;
		String currUrl;
		for( int i = 0; i < n; i++) {
			
			currPath = pathList.get(i);
			currUrl = urlList.get(i);
			System.out.println(currUrl);
			url = new Url();
		
			url.setUrl(currUrl);
			url.setPath(currPath);
			url.setTitle(parserHelper.getTitle(currPath));
			url.setContent(parserHelper.getContent(currPath));
			//保存url 
			urlDAO.attachDirtyUrl(url);
		}
		
		System.out.println("STORE URL !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				
	}
	
	
	//删除缓存表
	@Override
	public void clearCache() {
		keywordDAO.deleteAll();
	}
	
	//get and set

	public UrlDAO getUrlDAO() {
		return urlDAO;
	}


	public void setUrlDAO(UrlDAO urlDAO) {
		this.urlDAO = urlDAO;
	}


	public KeywordDAO getKeywordDAO() {
		return keywordDAO;
	}


	public void setKeywordDAO(KeywordDAO keywordDAO) {
		this.keywordDAO = keywordDAO;
	}


	public Url getUrl() {
		return url;
	}


	public void setUrl(Url url) {
		this.url = url;
	}


}
