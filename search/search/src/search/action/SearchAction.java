package search.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import search.domain.Url;

@Controller
@Namespace("/")
@Scope("prototype")
@ParentPackage("search")
public class SearchAction {

	 @Resource 
	 private Url url;
	 
	 @Action(value = "loginAction", results = {  
		 @Result(name = "success", location = "/success.jsp")})
	 public String test() {
		 return "success";
	 }
	 
}
