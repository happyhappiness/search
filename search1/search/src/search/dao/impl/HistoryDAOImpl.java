package search.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import search.dao.HistoryDAO;
import search.domain.History;

@Repository
public class HistoryDAOImpl extends BaseDAOImpl<History> implements HistoryDAO{

	//�������Ի�ȡ
	@Override
	public List<History> findHistoryByProperty(String propertyName, Object value){
		return findByProperty( propertyName, value);
	}
	
	//����id����
	@Override
	public List<History> findById(int id) {
		return findByProperty("id",id);
	}

	@Override
	public List<History> findByWord(String word) {
		return findByProperty("word", word);
	}


}
