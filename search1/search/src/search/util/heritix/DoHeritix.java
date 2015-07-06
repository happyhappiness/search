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


//heritix接口模拟： 输出 url信息
public class DoHeritix {

	private ArrayList<String> infoList;
	private final String URL_FILE_PATH = "e:\\url.txt";
	private final String PATH_FILE_PATH = "e:\\path.txt";
	
	public DoHeritix(){
		infoList = new ArrayList<String>();
	}
	
    private void readFileByLines(String fileName) {
    	
    	//清空旧信息
    	infoList.clear();
    	
        File file = new File(fileName);
        BufferedReader reader = null;
        
        try {
			FileInputStream fInStream = new FileInputStream(file);
			reader = new BufferedReader(new InputStreamReader(fInStream,"UTF-8"));
			String tempString = null;
	            
            while ((tempString = reader.readLine()) != null) {
                //处理每行数据
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
    
    //返回urlList
    public List<String> getUrl(){
    	
    	readFileByLines(URL_FILE_PATH);
    	return infoList;
    }
    
   //返回pathList
    public List<String> getPath(){
    	
    	readFileByLines(PATH_FILE_PATH);
    	
    	return infoList;
    }
}
