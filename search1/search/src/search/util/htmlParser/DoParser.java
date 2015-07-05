package search.util.htmlParser;


import org.htmlparser.parserapplications.StringExtractor;
import org.htmlparser.util.ParserException;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.Parser;

/**
 * @author www.baizeju.com
 */
public class DoParser {
	private final String ENCODE = "GBK";
	private Parser parser;
	private NodeList nodeList;
	private NodeFilter filter;
	private StringExtractor stringExtractor;
	private final String TITLE = "title";
	private final boolean HASLINKS = false;
	
	public DoParser() {
		parser = new Parser();
	}

	
	//获取html文件的标题
	public String getTitle(String htmls) {
		Parser parser = new Parser();
		String title;
		
		filter = new TagNameFilter(TITLE);		
		try {
			parser.setURL(htmls);
			parser.setEncoding(ENCODE);
			nodeList = parser.parse(filter);
		} catch (ParserException e) {
			e.printStackTrace();
		}
		
		title = nodeList.elementAt(0).toPlainTextString();
		System.out.println("标题： " + title);

		return title;
	}

	//获取html文件正文
	public String getContent(String htmls){

		stringExtractor = new StringExtractor (htmls);
		String content = null;
		try {
			content = stringExtractor.extractStrings (HASLINKS); 
			System.out.println ("内容：" + content); 
			System.out.println ("==================================================="); 
		} catch (ParserException e) {
			e.printStackTrace();
		}
           
		return content;
	}

/*	public static void main(String[] args) {

		try {
			DoParser doParser = new DoParser();
			//TODO 输入html路径
			String htmls = "F:\\Sina-20150703010257062\\mirror\\2004.sina.com.cn\\index.html";
			
			//提取标题
			doParser.getTitle(htmls);

			//提取文本
			doParser.getContent(htmls);
			
		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
	}*/
}