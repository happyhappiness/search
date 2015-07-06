package search.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import search.dao.HistoryDAO;
import search.dao.UserDAO;
import search.domain.History;
import search.domain.User;
import search.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDAO userDAO;
	@Resource
	private HistoryDAO historyDAO;
	
	//根据用户名获取用户权限
	@Override
	public int getRight(String name) {
		//权限代码： 0 普通 1管理员 -1不存在
		int rightCode = -1;
		
		List<User> userList = userDAO.findUserByName(name);
		if(userList != null & userList.size() != 0){
			if(userList.get(0).getRight())
				rightCode = 1;
			else
				rightCode = 0;
		}
		else{
			rightCode = -1;
		}
		
		return rightCode;
	}
	
	//根据用户名获取访问记录
	@Override
	public List<String> getWords(String name) {
		List<String> wordList = new ArrayList<String>();
		List<History> historyList;
		User user;
		
		//获得用户
		List<User> userList = userDAO.findUserByName(name);
		if(userList != null & userList.size() != 0){
			user = userList.get(0);
			historyList = historyDAO.findById(user.getId());
			for(History history : historyList){
				wordList.add(history.getWord());
			}
		}
		
		return wordList;
	}

	//get and set
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


}
