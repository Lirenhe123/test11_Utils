package priv.lirenhe.util.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _1ReplaceSpecialStr {
	public static void main(String[] args) {
		String str="在编写网页时，如果直接在双引号之间输入路径，其中的“\\”及其之后的文本易被误认为转义字符。为避免这一点，C#等语言只需在字符串的引号前加“@”符号（不包括外侧引号）。如：@ c:\\ab\\cd\\ef.jpg";
		String result=replaceSpecStr(str);
		System.out.println(result);
	}
	
	/** 
	 * 正则替换所有特殊字符 
	 * @param orgStr 
	 * @return 
	 */  
	public static String replaceSpecStr(String orgStr){  
		if (null!=orgStr&&!"".equals(orgStr.trim())) {  
			String regEx="[\\s~·`!！@#￥$%^……&*（()）\\-——\\-_=+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";  
			Pattern p = Pattern.compile(regEx);  
			Matcher m = p.matcher(orgStr);  
			return m.replaceAll("");  
		}  
		return null;  
	}  
}