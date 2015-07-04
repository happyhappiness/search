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
	public String getTitle(String htmls) throws ParserException {
		Parser parser = new Parser();
		parser.setURL(htmls);
		parser.setEncoding(ENCODE);

		filter = new TagNameFilter(TITLE);
		nodeList = parser.parse(filter);
		for (NodeIterator i = nodeList.elements(); i.hasMoreNodes();) {
			Node node = i.nextNode();
			System.out.println("标题： " + node.toPlainTextString());
			System.out.println("=================================================");
		}
	}

	//获取html文件正文
	public String getContent(String htmls){

		stringExtractor = new StringExtractor (htmls);
        try
        {
            System.out.println (stringExtractor.extractStrings (HASLINKS));
        }
        catch (ParserException e)
        {
            e.printStackTrace ();
        }
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