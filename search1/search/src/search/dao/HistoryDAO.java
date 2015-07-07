package search.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import search.domain.History;

@Repository
public interface HistoryDAO {

	//根据属性获取
	List<History> findHistoryByProperty(String propertyName, Object value);
	
	//根据用户id获取
	List<History> findHistoryById(int id);
	
	//根据word获取
	List<History> findHistoryByWord(String word);

	//根据example获取
	List<History> findHistoryByExample(History history);
	
	//保存或更新历史记录
	void attachDirtyHistory(History history);
	
}
