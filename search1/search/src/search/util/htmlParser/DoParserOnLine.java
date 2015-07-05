package search.util.htmlParser;

import org.htmlparser.Parser;
import org.htmlparser.beans.StringBean;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.parserapplications.StringExtractor;
import org.htmlparser.util.ParserException;

public class DoParserOnLine extends DoParser{

	private final String ENCODE_ONLINE = "UTF-8";
	
	public DoParserOnLine() {
		parser = new Parser();
	}
	
	public String getTitle(String url){
		String title = null;
		
		filter = new TagNameFilter(TITLE);		
		try {
			parser.setURL(url);
			parser.setEncoding(ENCODE_ONLINE);
			nodeList = parser.parse(filter);
			title = nodeList.elementAt(0).toPlainTextString();
			System.out.println("标题： " + title);
		} catch (ParserException e) {
			e.printStackTrace();
		}
		
		return title;
	}
	
	public String getContent(String url) {
	
		StringBean textBean = new StringBean();
		String content = null;
		
		textBean.setURL(url);
		//设置对链接和空格的处理
		textBean.setLinks(false);    
		textBean.setReplaceNonBreakingSpaces(true);  
		textBean.setCollapse(true);  
		content = textBean.getStrings();
		
		System.out.println ("内容：" + content); 
		System.out.println ("==================================================="); 
		
		return content;
	}
	
	public static void main(String args[]) {
		
		DoParserOnLine parserHelper = new DoParserOnLine();
		String a = parserHelper.getTitle("http://www.baidu.com/");

		String b = parserHelper.getContent("http://www.baidu.com/");
	}
}
