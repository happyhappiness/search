package search.service;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface SpiderService {

	//����path��Ϣ���ɲ��洢url����
	void storeUrl(List<String> urlList, List<String> pathList);
}
