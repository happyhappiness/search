package search.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import search.domain.History;

@Repository
public interface HistoryDAO {

	//根据属性获取
	List<History> findHistoryByProperty(String propertyName, Object value);
	
	//根据用户id获取
	List<History> findById(int id);
	
	//根据word获取
	List<History> findByWord(String word);
}
