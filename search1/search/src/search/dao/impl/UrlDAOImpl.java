package search.dao.impl;

import java.util.List;



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
		List<Url> urlList = findByExample(url);
		if(urlList != null && urlList.size() != 0) {
			Url tempUrl = urlList.get(0);
			url.setUid(tempUrl.getUid());
		}
		attachDirty(url);
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
		return findByExample(url);	
	}

}
