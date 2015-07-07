package search.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

	//根据用户名访问用户权限
	public int getRight(String name, String passWord);
	
	//根据用户名获取用户访问记录
	public List<String> getWords(String name);
	
	//根据用户名和word保存用户访问记录
	public void saveHistory(String name, String word);
}
