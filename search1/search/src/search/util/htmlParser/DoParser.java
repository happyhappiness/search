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


}