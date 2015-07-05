package search.service.impl;

import java.util.List;

import javax.annotation.Resource;

import search.dao.impl.UrlDAOImpl;
import search.domain.Url;
import search.service.UrlService;

import org.springframework.stereotype.Service;

import search.dao.UrlDAO;

@Service
public class UrlServiceImpl extends UrlDAOImpl implements UrlService{

	@Resource 
	private UrlDAO urlDAO;

	@Override
	//根据路径获取url对象
	public List<Url> getUrlByPath(String path) {
		return urlDAO.findUrlByProperty("path", path);
	}

	//根据关键字获取url对象
	@Override
	public List<Url> getUrlByKeyword(String keyword) {
		return urlDAO.findUrlByProperty("keyword", keyword);
	}
	

	//获取未分析的url
	@Override
	public List<Url> getUrlByIndexed() {
		return urlDAO.findUrlByProperty("indexed", false);
	}

	//根据属性删除url
	@Override
	public void delteUrlByProperty(String propertyName, Object value) {
		List<Url> urlList = urlDAO.findUrlByProperty(propertyName, value);
		for(Url url : urlList) {
			urlDAO.deleteUrl(url);
		}
	}

	//保存或更新url
	@Override
	public void saveOrUpdateUrl(Url url) {
		urlDAO.attachDirtyUrl(url);
	}

	//get and set	
	public UrlDAO getUrlDAO() {
		return urlDAO;
	}

	public void setUrlDAO(UrlDAO urlDAO) {
		this.urlDAO = urlDAO;
	}

	
}
