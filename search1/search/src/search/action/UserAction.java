package search.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import search.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@Namespace("/")
@ParentPackage("struts-default")
public class UserAction extends ActionSupport {

	private String username;
	private String password;
	private List<String> wordsList;

	@Resource 
	private UserService userService;
	
	//用户登录管理
	@Action(value="login", results={
			@Result(name="admin", location="/admin.jsp"),
			@Result(name="user", location="/user.jsp"),
			@Result(name="none", location="/index.jsp"),
			@Result(name="error",location="/login.jsp")
	})
	public String login(){
		
		String result = "none";
		//根据用户名获取用户权限0：普通用户  1：管理员 -1不存在 -2密码错误
		int rightCode = userService.getRight(username, password);
		switch(rightCode){
			case 1:
				result = "admin";
				break;
			case 0:
				result = "user";
				//获取历史记录
				wordsList = userService.getWords(username);
				break;
			case -1:
				result = "none";
				break;
			case -2:
				result = "error";
		}
		
		return result;
	}
	
	
	//get and set
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public List<String> getWordsList() {
		return wordsList;
	}


	public void setWordsList(List<String> wordsList) {
		this.wordsList = wordsList;
	}

}
