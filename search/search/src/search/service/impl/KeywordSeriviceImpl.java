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
	
	//根据关键字内容获取关键字对象
	@Override
	public List getKeywordByWord(String word) {
		return keywordDAO.findKeywordByProperty("word", word);
	}

	//删除满足某属性值的keyword对象
	@Override
	public void deleteKeywordByProperty(String PropertyName, Object value) {
		List<Keyword> keywordList = keywordDAO.findKeywordByProperty(PropertyName, value);
		for(Keyword keyword : keywordList) {
			keywordDAO.deleteKeyword(keyword);
		}
	}
	
	//保存或更新keyword对象
	@Override
	public void savaOrUpdate(Keyword keyword) {
		keywordDAO.attachDirtyKeyword(keyword);
	}

}
