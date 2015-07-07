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
	public int getRight(String name, String password) {
		//权限代码： 0 普通 1管理员 -1不存在-2密码错误
		int rightCode = -1;
		
		List<User> userList = userDAO.findUserByName(name);
		if(userList != null & userList.size() != 0){
			User user = userList.get(0);
			if(user.getPassword().equals(password)){
				if(userList.get(0).getRight())
					rightCode = 1;
				else
					rightCode = 0;
			}
			else{
				rightCode = -2;
			}
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
			historyList = historyDAO.findHistoryById(user.getId());
			for(History history : historyList){
				wordList.add(history.getWord());
			}
		}
		
		return wordList;
	}
	
	//根据用户名和word保存用户搜索记录
	@Override
	public void saveHistory(String name, String word) {
		List<User> userList = userDAO.findUserByName(name);
		System.out.println(name);
		System.out.println(word);
		
		History history = new History();
		if(userList != null & userList.size() != 0) {
			history.setId(userList.get(0).getId());
			history.setWord(word);
			historyDAO.attachDirtyHistory(history);
		}
		
	}


	//get and set
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public HistoryDAO getHistoryDAO() {
		return historyDAO;
	}

	public void setHistoryDAO(HistoryDAO historyDAO) {
		this.historyDAO = historyDAO;
	}


}
