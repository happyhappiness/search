package search.service.impl;

import java.util.List;

import javax.annotation.Resource;

import javassist.compiler.ast.Keyword;

import org.springframework.stereotype.Service;

import search.dao.KeywordDAO;
import search.dao.impl.KeywordDAOImpl;
import search.service.KeywordService;

@Service
public class KeywordSeriviceImpl implements KeywordService {

	@Resource
	private KeywordDAO keywordDAO = new KeywordDAOImpl();
	
	//���ݹؼ������ݻ�ȡ�ؼ��ֶ���
	@Override
	public List getKeywordByWord(String word) {
		return keywordDAO.findKeywordByProperty("word", word);
	}

	//ɾ������ĳ����ֵ��keyword����
	@Override
	public void deleteKeywordByProperty(String PropertyName, Object value) {
		List<Keyword> keywordList = keywordDAO.findKeywordByProperty(PropertyName, value);
		for(Keyword keyword : keywordList) {
			keywordDAO.deleteKeyword(keyword);
		}
	}
	
	//��������keyword����
	@Override
	public void savaOrUpdate(Keyword keyword) {
		keywordDAO.attachDirtyKeyword(keyword);
	}

}
