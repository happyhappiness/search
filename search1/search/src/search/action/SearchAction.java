package search.action;


import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import search.domain.Keyword;
import search.domain.Url;
import search.service.SearchService;
import search.service.SpiderService;
import search.service.impl.SearchServiceImpl;
import search.service.impl.SpiderServiceImpl;

@Controller
@Namespace("/")
@Scope("prototype")
@ParentPackage("struts-default")
public class SearchAction {
	 
	 
	 @Resource
	 private SearchService searchService = new SearchServiceImpl();
	 private SpiderService spiderService = new SpiderServiceImpl();
	 private String queryString;
	 
	 @Action(value = "search", results = {  
		 @Result(name = "success", location = "/success.jsp")})
	 public String search() {
		 if(queryString != null){
			 System.out.println(queryString);
		 
		//使用SpiderService获取并存储url信息
			 List<String> urlList = spiderService.getUrlList();
//			 List<String> pathList = spiderService.getPathList();
			
			spiderService.storeUrl(urlList);
//			spiderService.storeUrl(urlList, pathList);
		    searchService.searchKeyword(queryString);
		 }
		 return "success";
		 
	 }


	//getter and setter

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	 
	 
}
