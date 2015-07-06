package search.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import search.service.SpiderService;

@Controller
@Namespace("/")
@Scope("prototype")
@ParentPackage("struts-default")
public class SpiderAction {

	private long urlSize;
	
	@Resource
	private SpiderService spiderService;
	
	@Action(value = "spider" )
	public void spider(){
		
		//使用SpiderService获取并存储url信息
		List<String> urlList = spiderService.getUrlList();
		List<String> pathList = spiderService.getPathList();
		
		spiderService.storeUrl(urlList, pathList);
		
		//更新缓存表信息
		long currUrlSize = spiderService.getUrlSize();
		if(urlSize != currUrlSize) {
			
			urlSize = currUrlSize;
			//删除keyword缓存表
			spiderService.clearCache();
		}
	}
}
