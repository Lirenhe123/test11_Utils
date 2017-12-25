package priv.lirenhe.util.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//一下代码仅作尝试
public class _2InsetInSpecificPlace {
	public static void main(String[] args) {
		String listUrl = "";
		File file = new File("E:\\WorkSpace03\\test11_Utils\\src\\priv\\lirenhe\\util\\string\\_2InsetInSpecificPlace.java");
		String strInsert = "alslflasdlflaslf";
		String[] strCodeArray = null;
		try {
			String strCode = readCodeFromFile(file);
			if(strCode.contains("listUrl")){
				strCodeArray = strCode.split("\n");
				for(String str : strCodeArray){
					if(str.contains("listUrl")){
						str = str.substring(str.indexOf("listUrl"));
						str = str.replaceAll("\\s+", "");
						StringBuffer oneLineSb = null;
						oneLineSb = new StringBuffer(str);
						int startInsert = oneLineSb.indexOf("listUrl=\"")+"listUrl=\"".length();
						oneLineSb.insert(startInsert,strInsert);
						listUrl = oneLineSb.toString();
						break;
					}
				}
				
				System.out.println(listUrl);
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	//读取文件中的代码
	public static String readCodeFromFile(File file) throws IOException{
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		String str = null;
		try {
			br = new BufferedReader(new FileReader(file));
			
			while((str = br.readLine()) != null){
				sb.append(str+"\n");
			}
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
}
