package search.service;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface SpiderService {

	//heritix�ӿڻ�ȡurl��Ϣ
	List<String> getUrlList();
	
	//heritix�ӿڻ�ȡpath��Ϣ
	List<String> getPathList();
		
	//����url��Ϣ��path��Ϣ���ɲ��洢url����
	void storeUrl(List<String> urlList, List<String> pathList);
	
	//ɾ�������
	void clearCache();
/*	//����url��Ϣ���ɲ��洢url����
	void storeUrl(List<String> urlList);*/
}
