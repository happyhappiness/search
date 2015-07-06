package search.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import search.domain.Url;
import search.domain.User;

@Repository
public interface UserDAO {

	//根据属性获取用户对象
	List<User> findUserByProperty(String propertyName, Object value);
	
	//根据name获取用户对象
	List<User> findUserByName(String name);
	
	//根据权限值获取用户对象
	List<User> findUserByRight(boolean right);
	
	//获取所有用户对象
	List<User> findAllUsers();
	long findAllUsersCount();
	
	//根据example获取指定用户
	List<User> findUserByExample(User user);
	
	//删除用户信息
	void delteUser(User user);
	
	//添加或更新用户信息
	void attachDirtyUser(User user);
	
	
}
