package search.action;


import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import search.domain.Keyword;
import search.domain.Url;

@Controller
@Namespace("/")
@Scope("prototype")
@ParentPackage("struts-default")
public class SearchAction {

	 @Resource 
	 private Url url;
	 private Keyword keyword;
	 
	 @Action(value = "search", results = {  
		 @Result(name = "success", location = "/success.jsp")})
	 public String test() {
		 if(keyword != null)
			 System.out.println(keyword.getWord());
		 else
			 System.out.println("why no ?");
			 
		 return "success";
	 }

	//getter and setter
	public Url getUrl() {
		return url;
	}

	public void setUrl(Url url) {
		this.url = url;
	}

	public Keyword getKeyWord() {
		return keyword;
	}

	public void setKeyWord(Keyword keyword) {
		this.keyword = keyword;
	}
	 
	 
}
