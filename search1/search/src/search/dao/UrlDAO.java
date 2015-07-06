package search.dao;

import java.util.List;



import org.springframework.stereotype.Repository;

import search.domain.Url;

@Repository
public interface UrlDAO {


	
	//ɾ��url��Ϣ
	void deleteUrl(Url url);
   
	//��ӻ����url 
	void attachDirtyUrl(Url url);
	
	//��ȡȫ�������Ϣ
    List<Url> findAllUrls();
    long findUrlsCount();
    
    //����id��ȡurl����
	List<Url> getUrlByUid(int uid);
	
	//����url��ȡurl����
	List<Url> getUrlByUrl(String url);
	
    //��������ֵ��ȡ����   
    List<Url> findUrlByProperty(String propertyName, Object value);
    

    //����example��ȡurl
    List<Url> findUrlByExample(Url url);
}
