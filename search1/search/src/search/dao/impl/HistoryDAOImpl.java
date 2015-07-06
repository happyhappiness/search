package search.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import search.dao.HistoryDAO;
import search.domain.History;

@Repository
public class HistoryDAOImpl extends BaseDAOImpl<History> implements HistoryDAO{

	//根据属性获取
	@Override
	public List<History> findHistoryByProperty(String propertyName, Object value){
		return findByProperty( propertyName, value);
	}
	
	//根据id访问
	@Override
	public List<History> findById(int id) {
		return findByProperty("id",id);
	}

	@Override
	public List<History> findByWord(String word) {
		return findByProperty("word", word);
	}


}
