package search.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import search.service.SpiderService;

@Controller
@Namespace("/")
@Scope("prototype")
@ParentPackage("struts-default")
public class SpiderAction extends ActionSupport {

	/*private long urlSize;*/
	private String message;
	
	

	@Resource
	private SpiderService spiderService;
	
	@Action(value = "spider", results = {
			@Result(name = SUCCESS, location = "/success.jsp")
	})
	//存储url数据到数据库
	public String spider(){
		
		//使用SpiderService获取并存储url信息
		List<String> urlList = spiderService.getUrlList();
		List<String> pathList = spiderService.getPathList();
		
		spiderService.storeUrl(urlList, pathList);
		
		//删除keyword缓存表
		spiderService.clearCache();
		message = "保存爬虫数据成功";
		
		return SUCCESS;
	}
	
	//get and get
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
