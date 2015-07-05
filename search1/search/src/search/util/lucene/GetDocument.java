package search.util.lucene;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;

/**
 * 
 * �����ݴ�������
 * 
 * �����ݴ洢��Document������װ�ز�ѯ��
 * 
 * */
public class GetDocument {
	
	private Document document;
	private ArrayList<String> title;
	private ArrayList<String> content;
	private ArrayList<String> index;
	
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
        
	}
	
	public void createIndex(IndexWriter indexWriter, String indexName, String[] fieldName) throws IOException{
		//��ʼ������
        getInitData();
        
        int n = content.size();
        for( int i = 0; i < n; i++) {
        	document = new Document();  
    	    document.add(new Field(indexName, index.get(i), Field.Store.YES, Field.Index.NOT_ANALYZED));  
            document.add(new Field(fieldName[0], title.get(i), Field.Store.YES, Field.Index.ANALYZED));  
            document.add(new Field(fieldName[1], content.get(i), Field.Store.YES, Field.Index.ANALYZED));  
            indexWriter.addDocument(document);  
        } 
	}
	
}
