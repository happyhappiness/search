package search.service;

import java.util.List;

import search.domain.Keyword;

import org.springframework.stereotype.Service;

@Service
public interface KeywordService {
	
	//���ݹؼ������ݻ�ȡ����
	List<Keyword> getKeywordByWord(String word);
	
	//��������ֵɾ������
	void deleteKeywordByProperty(String PropertyName, Object value);
	
	//�������¹ؼ��ֶ���
	void savaOrUpdate(Keyword keyword);
}
