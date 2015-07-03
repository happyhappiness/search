package testlucene;  
  
import java.io.IOException;  
import java.io.StringReader;  
  



import org.apache.lucene.analysis.Analyzer;  
import org.apache.lucene.analysis.TokenStream;  
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;  
import org.apache.lucene.document.Document;  
import org.apache.lucene.document.Field;  
import org.apache.lucene.index.IndexReader;  
import org.apache.lucene.index.IndexWriter;  
import org.apache.lucene.index.IndexWriterConfig;  
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;  
import org.apache.lucene.queryparser.classic.QueryParser;  
import org.apache.lucene.search.IndexSearcher;  
import org.apache.lucene.search.Query;  
import org.apache.lucene.search.ScoreDoc;  
import org.apache.lucene.search.TopDocs;  
import org.apache.lucene.store.RAMDirectory;  
import org.apache.lucene.util.Version;  
import org.wltea.analyzer.lucene.IKAnalyzer;  
  

/**
 * 《查询器》
 * 
 * 输入：关键词、Document数组
 * 输出：TopDoc
 * 
 * */

public class Lucene {  
	
	private final RAMDirectory directory;
	private final Analyzer analyzer;
	private final IndexWriterConfig writerConfig;
	private final IndexWriter indexWriter;
	private final IndexReader indexReader;
	private final IndexSearcher searcher;
	private final MultiFieldQueryParser parser;
	private Query query;
	private TopDocs topDocs;
	private final String INDEXNAME = "URL";
	private final String[] FIELDNAME = new String[] {"title", "content"};
	private final int TOPURL = 5;
	
	
	public Lucene() throws IOException {
		//初始化indexWriter
		directory = new RAMDirectory();//存储在内存中
		analyzer = new IKAnalyzer();
		writerConfig = new IndexWriterConfig(Version.LUCENE_34, analyzer); 
		indexWriter = new IndexWriter(directory, writerConfig); 
		
		//建立索引表
    	createIndex();
    	
		//初始化searcher和parser
		indexReader = IndexReader.open(directory);
		searcher = new IndexSearcher(indexReader);
		parser = new MultiFieldQueryParser(Version.LUCENE_40, FIELDNAME, analyzer);  
		parser.setDefaultOperator(QueryParser.OR_OPERATOR); 
	}
  
	
	//调用数据处理器，装载Document，建立索引表
	private void createIndex() throws IOException {
		GetDocument getDocument = new GetDocument();
		getDocument.createIndex(indexWriter, INDEXNAME, FIELDNAME);
		indexWriter.close();  
	} 
	
	//根据关键词查询
    public void query(String request) throws IOException {
    	
    	 try {  
             Query query = parser.parse(request);  
             TopDocs topDocs = searcher.search(query, TOPURL);  
             System.out.println("命中数:"+topDocs.totalHits);  
             ScoreDoc[] docs = topDocs.scoreDocs;  
             for(ScoreDoc doc : docs){  
                 Document d = searcher.doc(doc.doc);  
                 System.out.println("内容: "+ d.get(INDEXNAME) + "\t" +
                		 d.get(FIELDNAME[0]) + "\t" + d.get(FIELDNAME[1]));  
             }  
         } catch (ParseException e) {    
             e.printStackTrace();  
         }finally{
         	 clear();
         }  
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
