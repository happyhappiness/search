package lucene;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;


/**
 * 《交互界面》
 * 
 * 输入：用户关键词
 * 输出：搜索结果显示
 * 
 * 
 * */
public class DoQuery {

	 public static void main(String[] args) throws IOException {
		  Scanner in = new Scanner(new BufferedInputStream(System.in));
		  String request = in.next();
		  
		  //初始化查询器
		  Lucene lucene = new Lucene();
		  lucene.query(request);
	}
}
