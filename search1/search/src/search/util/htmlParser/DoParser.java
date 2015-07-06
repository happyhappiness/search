package search.util.htmlParser;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.nodes.TagNode;
import org.htmlparser.parserapplications.StringExtractor;
import org.htmlparser.util.ParserException;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.beans.StringBean;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.Parser;

/**
 * @author www.baizeju.com
 */
public class DoParser {
	protected Parser parser;
	protected NodeList nodeList;
	protected NodeFilter filter;
	protected StringExtractor stringExtractor;
	protected final String TITLE = "title";
	protected final boolean HASLINKS = false;


	public DoParser(){
		parser = new Parser();
	}
	
	// 获取html文件的标题
	public String getTitle(String path) {
		String title = " ";

		filter = new TagNameFilter(TITLE);
		try {
			parser.setURL(path);
			parser.setEncoding(getEncode(path));
			nodeList = parser.parse(filter);
			if(nodeList != null && nodeList.size() != 0)
				title = nodeList.elementAt(0).toPlainTextString();		
		} catch (ParserException e) {
			e.printStackTrace();
		}

		System.out.println("标题： " + title);
		return title;
	}

	// 获取html文件正文
	public String getContent(String path) {

		StringBean textBean = new StringBean();
		String content = " ";
		
		textBean.setURL(path);
		//设置对链接和空格的处理
		textBean.setLinks(false);    
		textBean.setReplaceNonBreakingSpaces(true);  
		textBean.setCollapse(true);  
		content = textBean.getStrings();
		
		System.out.println ("内容：" + content); 
		System.out.println ("==================================================="); 
		
		return content;
	}
	
	//获取网页编码格式
	private String getEncode(String path){//根据正则匹配得到页面编码
         
		String encode="UTF-8";
        /*Pattern p = Pattern.compile("(charset|Charset|CHARSET)\\s*=\\s*\"?\\s*([-\\w]*?)[^-\\w]"); 
        Matcher m = p.matcher(path);
	     if(m.find()){ 
	          encode = m.group(2);
	      }
         System.out.println(encode);
         return encode;*/
		Parser parser;
		try {
			parser = new Parser();
			parser.setURL(path);
			parser.setEncoding(parser.getEncoding());
			NodeFilter tagFilter = new TagNameFilter("meta");
			HasAttributeFilter haf = new HasAttributeFilter("charset");
			AndFilter af = new AndFilter(tagFilter,haf);
			NodeList nodes = parser.extractAllNodesThatMatch(af);
			if (nodes != null && nodes.size() != 0) {
				TagNode liTag = (TagNode) nodes.elementAt(0);
				encode = liTag.getAttribute("charset").trim();
			}
		} catch (ParserException e) {
			e.printStackTrace();
		}
		System.out.println(encode);
		return encode;
	}
	
	public static void main(String args[]) {
		
		DoParser doParser = new DoParser();
		doParser.getTitle("f:\\Start_5\\mirror\\list.taobao.com\\browse\\ad_search.htm");
	}
	
}