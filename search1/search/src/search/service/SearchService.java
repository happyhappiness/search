package search.service;

import java.util.List;

import search.domain.Url;

public interface SearchService {

	//����������
	void updateIndex();
	
	//���ݹؼ�������
	List<Url> searchKeyword(String word);
}
