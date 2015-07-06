package search.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import search.dao.UserDAO;
import search.domain.User;

@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO{

	//根据属性获取
	@Override
	public List<User> findUserByProperty(String propertyName, Object value) {
		
		return findByProperty( propertyName, value);
	}

	//根据name获取
	@Override
	public List<User> findUserByName(String name) {
		
		return findByProperty("name",name);
	}

	//根据权限值获取
	@Override
	public List<User> findUserByRight(boolean right) {
		return findByProperty( "right", right);
	}

	//获取所有用户
	@Override
	public List<User> findAllUsers() {
		return findAll(User.class);
	}

	//获取用户总数
	@Override
	public long findAllUsersCount() {
		return findCount(User.class);
	}

	//根据example获取
	@Override
	public List<User> findUserByExample(User user) {
		return findByExample(user);
	}

	//删除实体对象
	@Override
	public void delteUser(User user) {
		delete(user);
	}

	//添加或更新用户
	@Override
	public void attachDirtyUser(User user) {
		//根据example获取用户
		List<User> userList = findByExample(user);
		if(userList != null && userList.size() != 0){
			user.setId(userList.get(0).getId());
		}
		
		//保存或更新用户
		attachDirty(user);
	}

}
