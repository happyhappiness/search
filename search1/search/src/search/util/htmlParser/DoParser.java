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
public abstract class DoParser {
	protected Parser parser;
	protected NodeList nodeList;
	protected NodeFilter filter;
	protected StringExtractor stringExtractor;
	protected final String TITLE = "title";
	protected final boolean HASLINKS = false;

	//获取html文件的标题
	abstract public String getTitle(String path) ;

	//获取html文件正文
	abstract public String getContent(String path);

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