package search.dao.impl;

import java.util.List;

import org.hibernate.Query;
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
	public List<History> findHistoryById(int id) {
		return findByProperty("id",id);
	}

	@Override
	public List<History> findHistoryByWord(String word) {
		return findByProperty("word", word);
	}
	
	//����example��ȡ
	@Override
	public List<History> findHistoryByExample(History history){
		
		Query query = getSessionFactory().getCurrentSession()
		        .createQuery("from History where id = ? and word = ?");
		query.setInteger(0, history.getId());
		query.setString(1, history.getWord());
		
		return query.list();
	}

	//���»������ʷ��¼
	@Override
	public void attachDirtyHistory(History history) {
		List<History> historyList = findHistoryByExample(history);
		if(historyList != null && historyList.size() != 0) {
			History tempHistory = historyList.get(0);
			attachDirty(tempHistory);
		}
		else{
			attachDirty(history);
		}
	}


}
