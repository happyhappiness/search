package search.service;

import java.util.List;

import search.domain.Url;

public interface SearchService {

	//���ݹؼ�������
	List<Url> searchKeyword(String word);
}
