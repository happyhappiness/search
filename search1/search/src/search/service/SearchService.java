package search.service;

import java.util.List;

import search.domain.Url;

public interface SearchService {

	//¸ù¾Ý¹Ø¼ü´ÊËÑË÷
	List<Url> searchKeyword(String word);
}
