package search.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import search.domain.History;

@Repository
public interface HistoryDAO {

	//�������Ի�ȡ
	List<History> findHistoryByProperty(String propertyName, Object value);
	
	//�����û�id��ȡ
	List<History> findById(int id);
	
	//����word��ȡ
	List<History> findByWord(String word);
}
