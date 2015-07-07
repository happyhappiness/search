package search.dao.impl;

import java.util.List;




import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import search.dao.UrlDAO;
import search.domain.Url;

@Repository
public class UrlDAOImpl extends BaseDAOImpl<Url> implements UrlDAO{

	
	//ɾ��url��Ϣ
	@Override
	public void deleteUrl(Url url){
		delete(url);
	}
   
	//��ӻ����url 
	@Override
	public void attachDirtyUrl(Url url){
		//����ʵ���ѯUrl��
		List<Url> urlList = findUrlByExample(url);
		if(urlList != null && urlList.size() != 0) {
			Url tempUrl = urlList.get(0);
			tempUrl.setPath(url.getPath());
			tempUrl.setTitle(url.getTitle());
			tempUrl.setContent(url.getContent());
			attachDirty(tempUrl);
		}
		else{
			attachDirty(url);
		}
	}
	
	//��ȡȫ�������Ϣ
    public List<Url> findAllUrls(){
    	return findAll(Url.class);
    }
    
    public long findUrlsCount(){
    	return findCount(Url.class);
    }
    
	//����������ȡurl����
	@Override
	public List<Url> getUrlByUid(int uid) {
		return findByProperty("uid", uid);
	}


	//����url��ȡurl����
	@Override
	public List<Url> getUrlByUrl(String url) {
		
		return findByProperty("url", url);
	}
	
    //��������ֵ��ȡ����   
    public List<Url> findUrlByProperty(String propertyName, Object value) {
    	return findByProperty(propertyName, value);
    }

    //����example��ȡ����
	@Override
	public List<Url> findUrlByExample(Url url) {
		Query query = getSessionFactory().getCurrentSession()
		        .createQuery("from Url where url = ?");
				query.setString(0, url.getUrl());	
				return query.list();
	}

}
