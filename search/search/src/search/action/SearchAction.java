package search.action;


import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import search.domain.Keyword;
import search.domain.Url;
import search.service.SearchService;
import search.service.impl.SearchServiceImpl;

@Controller
@Namespace("/")
@Scope("prototype")
@ParentPackage("struts-default")
public class SearchAction {
	 
	 private String queryString;
	 
	 @Resource
	 private SearchService searchService = new SearchServiceImpl();
	 
	 @Action(value = "search", results = {  
		 @Result(name = "success", location = "/success.jsp")})
	 public String search() {
		 if(queryString != null){
			 System.out.println(queryString);
			 
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
