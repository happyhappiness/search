package search.util.heritix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//heritix�ӿ�ģ�⣺ ��� url��Ϣ
public class DoHeritix {

	private ArrayList<String> infoList;
	private final String URL_FILE_PATH = "e:\\url.txt";
	private final String PATH_FILE_PATH = "e:\\path.txt";
	
	public DoHeritix(){
		infoList = new ArrayList<String>();
	}
	
    private void readFileByLines(String fileName) {
    	
    	//��վ���Ϣ
    	infoList.clear();
    	
        File file = new File(fileName);
        BufferedReader reader = null;
        
        try {
			FileInputStream fInStream = new FileInputStream(file);
			reader = new BufferedReader(new InputStreamReader(fInStream,"UTF-8"));
			String tempString = null;
	            
            while ((tempString = reader.readLine()) != null) {
                //����ÿ������
           	  infoList.add(tempString);
            }
        } catch (Exception e) {
			e.printStackTrace();
		} finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
    
    //����urlList
    public List<String> getUrl(){
    	
    	readFileByLines(URL_FILE_PATH);
    	return infoList;
    }
    
   //����pathList
    public List<String> getPath(){
    	
    	readFileByLines(PATH_FILE_PATH);
    	
    	return infoList;
    }
}
