package search.util.lucene;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;

import search.domain.Url;
import search.service.UrlService;
import search.service.impl.UrlServiceImpl;

/**
 * 
 * �����ݴ�������
 * 
 * �����ݴ洢��Document������װ�ز�ѯ��
 * 
 * */
public class GetDocument {
	
	private Document document;
	private ArrayList<Url> urlList;
	
	/*
	//��ȡԭʼ����
	private void getInitData() {
		//TODO //Ԫ����  
        String text1[] = {"����","IK Analyzer��һ����ϴʵ�ִʺ��ķ��ִʵ����ķִʿ�Դ���߰�����ʹ����ȫ�µ����������ϸ������" +  
                "���㷨��"};  
        String text2[] = {"����","���ķִʹ��߰����Ժ�lucene��һ��ʹ�õ�"};  
        String text3[] = {"�ִ�","���ķִ�,����"}; 
        String text4[] = {"���ķִʹ�����","����ʵ�Ǹ������ż"}; 
        
        //������Ϣ����
        title = new ArrayList<String> ();
        title.add(text1[0]);
        title.add(text2[0]);
        title.add(text3[0]); 
        title.add(text4[0]); 
        
        content = new ArrayList<String> ();
        content.add(text1[1]);
        content.add(text2[1]);
        content.add(text3[1]); 
        content.add(text4[1]); 
        
        index = new ArrayList<String> ();
        index.add("https://soni.com");
        index.add("https://hanmi.com");
        index.add("https://adhui.com");
        index.add("https://baiduhsi.com");
        
	}*/
	
	public void createIndex(IndexWriter indexWriter, String indexName, String[] fieldName) throws IOException{
		//�������ݿ⣬��ȡ��������url����
		UrlService urlService = new UrlServiceImpl();
		urlList = (ArrayList<Url>) urlService.getUrlByIndexed();
        
       for(Url url : urlList) {
    	   
    	    //����url����״̬
    	    url.setIndexed(true);
    	    urlService.saveOrUpdateUrl(url);
    	    
        	document = new Document();  
    	    document.add(new Field(indexName, url.getUrl(), Field.Store.YES, Field.Index.NOT_ANALYZED));  
            document.add(new Field(fieldName[0], url.getTitle(), Field.Store.YES, Field.Index.ANALYZED));  
            document.add(new Field(fieldName[1], url.getContent(), Field.Store.YES, Field.Index.ANALYZED));  
            indexWriter.addDocument(document);  
        } 
	}
	
}
