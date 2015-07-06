package search.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import search.dao.UserDAO;
import search.domain.User;

@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO{

	//�������Ի�ȡ
	@Override
	public List<User> findUserByProperty(String propertyName, Object value) {
		
		return findByProperty( propertyName, value);
	}

	//����name��ȡ
	@Override
	public List<User> findUserByName(String name) {
		
		return findByProperty("name",name);
	}

	//����Ȩ��ֵ��ȡ
	@Override
	public List<User> findUserByRight(boolean right) {
		return findByProperty( "right", right);
	}

	//��ȡ�����û�
	@Override
	public List<User> findAllUsers() {
		return findAll(User.class);
	}

	//��ȡ�û�����
	@Override
	public long findAllUsersCount() {
		return findCount(User.class);
	}

	//����example��ȡ
	@Override
	public List<User> findUserByExample(User user) {
		return findByExample(user);
	}

	//ɾ��ʵ�����
	@Override
	public void delteUser(User user) {
		delete(user);
	}

	//��ӻ�����û�
	@Override
	public void attachDirtyUser(User user) {
		//����example��ȡ�û�
		List<User> userList = findByExample(user);
		if(userList != null && userList.size() != 0){
			user.setId(userList.get(0).getId());
		}
		
		//���������û�
		attachDirty(user);
	}

}
