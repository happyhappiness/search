package search.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

	//�����û��������û�Ȩ��
	public int getRight(String name);
	
	//�����û�����ȡ�û����ʼ�¼
	public List<String> getWords(String name);
}
