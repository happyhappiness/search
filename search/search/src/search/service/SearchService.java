package search.service;

import java.util.List;

import search.domain.Keyword;

public interface SearchService {

	//���ݹؼ�������
	List<Keyword> searchKeyword(String word);
}
