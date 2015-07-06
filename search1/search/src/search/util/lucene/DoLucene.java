package search.util.lucene;  
  
import java.io.File;
import java.io.IOException;  
  







import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;  
import org.apache.lucene.document.Document;  
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;  
import org.apache.lucene.index.IndexWriter;  
import org.apache.lucene.index.IndexWriterConfig;  
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;  
import org.apache.lucene.queryparser.classic.QueryParser;  
import org.apache.lucene.search.IndexSearcher;  
import org.apache.lucene.search.Query;  
import org.apache.lucene.search.ScoreDoc;  
import org.apache.lucene.search.TopDocs;  
import org.apache.lucene.store.Directory; 
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;  
import org.wltea.analyzer.lucene.IKAnalyzer;  

import search.domain.Url;
  

/**
 * 《查询器》
 * 
 * 输入：关键词、Document数组
 * 输出：TopDoc
 * 
 * */

public class DoLucene {  
	
	private Directory directory;
	private Analyzer analyzer;
	private IndexWriterConfig writerConfig;
	private IndexWriter indexWriter;
	private IndexReader indexReader;
	private IndexSearcher searcher;
	private MultiFieldQueryParser parser;
	private List<Url> urlList;
	private Query query;
	private TopDocs topDocs;
	private final String indexPath = "e:\\index";
	private final String INDEXNAME = "url";
	private final String[] FIELDNAME = new String[] {"title", "content"};
	private final int TOPURL = 5;
	
	//根据关键词查询
    public List<String> query(String request) throws IOException {

		//初始化searcher和parser
    	directory = SimpleFSDirectory.open(new File(indexPath));//存储在内存中
		indexReader = IndexReader.open(directory);
		searcher = new IndexSearcher(indexReader);
		parser = new MultiFieldQueryParser(Version.LUCENE_40, FIELDNAME, analyzer);  
		parser.setDefaultOperator(QueryParser.OR_OPERATOR); 
		
    	List<String> urlNameList = new ArrayList<String>();
    	
    	 try {  
             Query query = parser.parse(request);  
             TopDocs topDocs = searcher.search(query, TOPURL);  
             System.out.println("命中数:"+topDocs.totalHits);  
             ScoreDoc[] docs = topDocs.scoreDocs;  
             for(ScoreDoc doc : docs){  
                 Document d = searcher.doc(doc.doc);  
                 urlNameList.add(d.get(INDEXNAME));
                 System.out.println("内容: "+ d.get(INDEXNAME) + "\t" +
                		 d.get(FIELDNAME[0]) + "\t" + d.get(FIELDNAME[1]));  
             }  
         } catch (ParseException e) {    
             e.printStackTrace();  
         }finally{
         	 clear();         	
         }  
    	 
    	 return urlNameList;
    }
	
	//调用数据处理器，装载Document，建立索引表
	public void createIndex(List<Url> urlList) throws IOException {
		
		//初始化indexWriter
		directory = SimpleFSDirectory.open(new File(indexPath));//存储在内存中
		analyzer = new IKAnalyzer();
		writerConfig = new IndexWriterConfig(Version.LUCENE_34, analyzer);
		//更新索引表
		writerConfig.setOpenMode(OpenMode.CREATE);
		indexWriter = new IndexWriter(directory, writerConfig); 
		this.urlList = urlList;
				
		Document document;
		for(Url url : urlList) {			
        	document = new Document();  
    	    document.add(new Field(INDEXNAME, url.getUrl(), Field.Store.YES, Field.Index.NOT_ANALYZED));  
            document.add(new Field(FIELDNAME[0], url.getTitle(), Field.Store.YES, Field.Index.ANALYZED));  
            document.add(new Field(FIELDNAME[1], url.getContent(), Field.Store.YES, Field.Index.ANALYZED));  
            indexWriter.addDocument(document);  
        } 
		indexWriter.close();  
	} 
	
	
	
    //释放资源
    private void clear() {
    	//释放资源
        if(indexReader != null){  
            try{  
                indexReader.close();  
            }catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
          
        if(directory != null){  
            try{  
                directory.close();  
            }catch (Exception e) {  
                e.printStackTrace();  
            }  
        } 
    }   
  
}  
