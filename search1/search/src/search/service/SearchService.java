package search.service;

import java.util.List;

import search.domain.Keyword;

public interface SearchService {

	//¸ù¾Ý¹Ø¼ü´ÊËÑË÷
	List<Keyword> searchKeyword(String word);
}
