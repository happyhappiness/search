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
	//�洢url���ݵ����ݿ�
	public String spider(){
		
		//ʹ��SpiderService��ȡ���洢url��Ϣ
		List<String> urlList = spiderService.getUrlList();
		List<String> pathList = spiderService.getPathList();
		
		spiderService.storeUrl(urlList, pathList);
		
		//ɾ��keyword�����
		spiderService.clearCache();
		message = "�����������ݳɹ�";
		
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
