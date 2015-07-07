package search.action;


import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import search.domain.Url;
import search.service.SearchService;
import search.service.SpiderService;
import search.service.UserService;

@Controller
@Namespace("/")
@Scope("prototype")
@ParentPackage("struts-default")
public class SearchAction extends ActionSupport{
	 
	 
	 @Resource
	 private SearchService searchService;
	 @Resource
	 private SpiderService spiderService;
	 @Resource
	 private UserService userService;
	 private String queryString;
	 private String username;
	 private List<Url> urlList;
	


	@Action(value = "search", results = {  
		 @Result(name = "success", location = "/result.jsp")})
	 public String search() {
		 if(queryString != null){
		
			//搜索
			urlList = searchService.searchKeyword(queryString);
			//调整显示内容
			for(Url url : urlList) {
				url.setContent(url.getContent().substring(0,1000));
			}
		    return SUCCESS;
		    
		 }		 
		 return ERROR;
		 	 
	 }

	@Action(value = "searchForUser", results = {  
		 @Result(name = "success", location = "/resultForUser.jsp")})
	 public String searchForUser() {
		 if(queryString != null){
		
			//搜索
			urlList = searchService.searchKeyword(queryString);
			//跳转显示content前1000字
			for(Url url : urlList) {
				url.setContent(url.getContent().substring(0,1000));
			}
			 
		    //保存用户历史信息
		    userService.saveHistory(username, queryString);
		    
		    return SUCCESS;
		    
		 }		 
		 return ERROR;
		 	 
	 }

	//getter and setter

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	 
	 
	public SearchService getSearchService() {
		return searchService;
	}


	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}


	public SpiderService getSpiderService() {
		return spiderService;
	}


	public void setSpiderService(SpiderService spiderService) {
		this.spiderService = spiderService;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<Url> getUrlList() {
		return urlList;
	}

	public void setUrlList(List<Url> urlList) {
		this.urlList = urlList;
	}

	
}
