package search.util.htmlParser;

import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.parserapplications.StringExtractor;
import org.htmlparser.util.ParserException;

public class DoParserOffLine extends DoParser {

	private final String ENCODE_OFFLINE = "GBK";

	public DoParserOffLine() {
		parser = new Parser();
	}
	
	// 获取html文件的标题
	public String getTitle(String path) {
		String title;

		filter = new TagNameFilter(TITLE);
		try {
			parser.setURL(path);
			parser.setEncoding(ENCODE_OFFLINE);
			nodeList = parser.parse(filter);
		} catch (ParserException e) {
			e.printStackTrace();
		}

		title = nodeList.elementAt(0).toPlainTextString();
		System.out.println("标题： " + title);

		return title;
	}

	// 获取html文件正文
	public String getContent(String path) {

		stringExtractor = new StringExtractor(path);
		String content = null;
		try {
			content = stringExtractor.extractStrings(HASLINKS);
			System.out.println("内容：" + content);
			System.out
					.println("===================================================");
		} catch (ParserException e) {
			e.printStackTrace();
		}

		return content;
	}
}
