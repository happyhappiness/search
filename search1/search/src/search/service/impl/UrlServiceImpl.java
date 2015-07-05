package search.service.impl;

import java.util.List;

import javax.annotation.Resource;

import search.dao.UrlDAO;
import search.dao.impl.UrlDAOImpl;
import search.domain.Url;
import search.service.UrlService;

import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl extends UrlDAOImpl implements UrlService{

	@Resource 
	private UrlDAO urlDAO = new UrlDAOImpl();
	@Override
	
	public List<Url> getUrlByPath(String path) {
		return urlDAO.findUrlByProperty("path", path);
	}

	@Override
	public List<Url> getUrlByKeyword(String keyword) {
		return urlDAO.findUrlByProperty("keyword", keyword);
	}

	@Override
	public void delteUrlByProperty(String propertyName, Object value) {
		List<Url> urlList = urlDAO.findUrlByProperty(propertyName, value);
		for(Url url : urlList) {
			urlDAO.deleteUrl(url);
		}
	}

	@Override
	public void saveOrUpdateUrl(Url url) {
		urlDAO.attachDirtyUrl(url);
	}

	
}
