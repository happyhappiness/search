package lucene;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;

/**
 * 
 * 《数据处理器》
 * 
 * 将数据存储到Document数组以装载查询器
 * 
 * */
public class GetDocument {
	
	private Document document;
	private ArrayList<String> title;
	private ArrayList<String> content;
	private ArrayList<String> index;
	
	//获取原始数据
	private void getInitData() {
		//TODO //元数据  
        String text1[] = {"中文","IK Analyzer是一个结合词典分词和文法分词的中文分词开源工具包。它使用了全新的正向迭代最细粒度切" +  
                "分算法。"};  
        String text2[] = {"工具","中文分词工具包可以和lucene是一起使用的"};  
        String text3[] = {"分词","中文分词,你妹"}; 
        String text4[] = {"中文分词工具器","我其实是个大好人偶"}; 
        
        //生成信息数组
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
		//初始化数据
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
