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
		
		//ʹ��SpiderService��ȡ���洢url��Ϣ
		List<String> urlList = spiderService.getUrlList();
		List<String> pathList = spiderService.getPathList();
		
		spiderService.storeUrl(urlList, pathList);
		
		//���»������Ϣ
		long currUrlSize = spiderService.getUrlSize();
		if(urlSize != currUrlSize) {
			
			urlSize = currUrlSize;
			//ɾ��keyword�����
			spiderService.clearCache();
		}
	}
}
