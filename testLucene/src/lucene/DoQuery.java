package lucene;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;


/**
 * ���������桷
 * 
 * ���룺�û��ؼ���
 * ��������������ʾ
 * 
 * 
 * */
public class DoQuery {

	 public static void main(String[] args) throws IOException {
		  Scanner in = new Scanner(new BufferedInputStream(System.in));
		  String request = in.next();
		  
		  //��ʼ����ѯ��
		  Lucene lucene = new Lucene();
		  lucene.query(request);
	}
}
