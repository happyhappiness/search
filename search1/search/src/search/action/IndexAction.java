package search.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller; 

import com.opensymphony.xwork2.ActionSupport;

import search.domain.Url;
import search.service.SearchService;
import search.service.impl.SearchServiceImpl;


@Controller
@Namespace("/")
@Scope("prototype")
@ParentPackage("struts-default")
public class IndexAction extends ActionSupport{

	private String message;
	 
	 @Resource 
	 private SearchService searchService = new SearchServiceImpl();

	@Action(value = "index", results = {
			@Result(name = SUCCESS, location = "/success.jsp")
	})
	 public String index() {
		 
		 //更新索引表
		 searchService.updateIndex();
		 message = "更新索引列表成功";
		 return SUCCESS;
	 }
	
	//get and set
	 public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

}
