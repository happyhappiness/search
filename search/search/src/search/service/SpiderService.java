package search.service;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface SpiderService {

	//根据path信息生成并存储url对象
	void storeUrl(List<String> urlList, List<String> pathList);
}
