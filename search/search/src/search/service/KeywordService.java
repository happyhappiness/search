package search.service;

import java.util.List;

import javassist.compiler.ast.Keyword;

import org.springframework.stereotype.Service;

@Service
public interface KeywordService {
	
	//根据关键字内容获取对象
	List<Keyword> getKeywordByWord(String word);
	
	//根据属性值删除对象
	void deleteKeywordByProperty(String PropertyName, Object value);
	
	//保存或更新关键字对象
	void savaOrUpdate(Keyword keyword);
}
