package copeIO;

import java.io.UnsupportedEncodingException;

/**
 * 截取字符串中某一长度的字符串
 * @author 厉昀键
 * Created on 2017年12月4日
 * 类说明
 * 
 */
public class Trim {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "我 a 爱中华 abc 我爱科技 def";
		String str1 = "我 ABC 汗";
		
		int num = trimGBK(str.getBytes("GBK"), 5);
		System.out.println(str.substring(0, num));
	}
	
	public static int trimGBK(byte[] buf,int i){
		int num = 0;
		boolean bChineseFirstHalf = false;
		for (int j = 0; j < i; j++) {
			if (buf[j]<0 && !bChineseFirstHalf) {
				bChineseFirstHalf = true;
			} else {
				num++;
				bChineseFirstHalf = false;
			}
		}
		return num;
	}
}
