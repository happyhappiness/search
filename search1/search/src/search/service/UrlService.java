package search.service;

import java.util.List;

import org.springframework.stereotype.Service;

import search.domain.Url;

@Service
public interface UrlService {
	
	//����path��ȡurl
	List<Url> getUrlByPath(String path);
	
	//����keyword��ȡurl
	List<Url> getUrlByKeyword(String keyword);
	
	//��ȡ����url
	List<Url> getUrlByIndexed();
	
	//ɾ��url
	void delteUrlByProperty(String propertyName, Object value);
	
	//����url
	void saveOrUpdateUrl(Url url);

}
