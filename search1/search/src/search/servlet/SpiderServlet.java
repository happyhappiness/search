package search.servlet;

import javax.servlet.http.HttpServlet;


public class SpiderServlet extends HttpServlet{

	
		//静态代码块，执行爬虫程序，存储url
		static{
			
			//TODO 启动爬虫程序
			System.out.println("Heritix working");
			/*//使用SpiderService获取并存储url信息
			SpiderService spiderService = new SpiderServiceImpl();
			List<String> urlList = spiderService.getUrlList();
//			List<String> pathList = spiderService.getPathList();
			
			spiderService.storeUrl(urlList);
//			spiderService.storeUrl(urlList, pathList);
	*/	}

}
