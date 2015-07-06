package search.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import search.domain.Url;
import search.domain.User;

@Repository
public interface UserDAO {

	//�������Ի�ȡ�û�����
	List<User> findUserByProperty(String propertyName, Object value);
	
	//����name��ȡ�û�����
	List<User> findUserByName(String name);
	
	//����Ȩ��ֵ��ȡ�û�����
	List<User> findUserByRight(boolean right);
	
	//��ȡ�����û�����
	List<User> findAllUsers();
	long findAllUsersCount();
	
	//����example��ȡָ���û�
	List<User> findUserByExample(User user);
	
	//ɾ���û���Ϣ
	void delteUser(User user);
	
	//��ӻ�����û���Ϣ
	void attachDirtyUser(User user);
	
	
}
