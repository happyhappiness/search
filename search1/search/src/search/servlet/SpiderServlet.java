package search.servlet;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import search.service.SpiderService;
import search.service.impl.SpiderServiceImpl;

public class SpiderServlet extends HttpServlet{

	/*	public void init() throws ServletException{
			super.init();
			getSpiderService();
		}
	
		static SpiderService spiderService;*/
		//判断url表是否更新
		static long CACHE_VALID_FLAG;
		
		//静态代码块，执行爬虫程序，存储url
		static{
			
			//TODO 启动爬虫程序
			/**
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * */
			
			System.out.println("Heritix working");
			
		}
		
		/*public static void storeUrlTable(){
			
			//使用SpiderService获取并存储url信息
			List<String> urlList = spiderService.getUrlList();
			List<String> pathList = spiderService.getPathList();
			
			spiderService.storeUrl(urlList, pathList);
		}

		//更新
		public static void updateUrlSize(){
			
			long currUrlSize = spiderService.getUrlSize();
			if(urlSize != currUrlSize) {
				
				urlSize = currUrlSize;
				
				//删除keyword缓存表
				spiderService.clearCache();
			}
		}
		
		//get and set
		public static SpiderService getSpiderService() {
			return spiderService;
		}

		public static void setSpiderService(SpiderService spiderService) {
			SpiderServlet.spiderService = spiderService;
		}*/

}
