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
		//�ж�url���Ƿ����
		static long CACHE_VALID_FLAG;
		
		//��̬����飬ִ��������򣬴洢url
		static{
			
			//TODO �����������
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
			
			//ʹ��SpiderService��ȡ���洢url��Ϣ
			List<String> urlList = spiderService.getUrlList();
			List<String> pathList = spiderService.getPathList();
			
			spiderService.storeUrl(urlList, pathList);
		}

		//����
		public static void updateUrlSize(){
			
			long currUrlSize = spiderService.getUrlSize();
			if(urlSize != currUrlSize) {
				
				urlSize = currUrlSize;
				
				//ɾ��keyword�����
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
