package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 创建文件并且添加、修改、读取内容
 * @author 厉昀键
 * Created on 2017年12月12日
 * 类说明
 *
 */
public class CreateFile {
	
	private static String  filePath = "/Users/liyunjian/Downloads/";
	private static String fileName = "newText";
	private static String fileTemp = null;
	
	public static void main(String[] args) {
		try {
			createFile();
			writeFile();
			readFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//创建文件
	public static void createFile() throws IOException{
		fileTemp = filePath + fileName + ".txt";
		File file = new File(fileTemp);
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("创建"+fileName+"文件成功！");
		}
	}
	//往文件里添加内容
	public static void writeFile(){
		fileTemp = filePath + fileName + ".txt";
		String content = "abcdef";
		FileOutputStream fos = null;
		StringBuffer sb = new StringBuffer();
		Map<String, String> map = new HashMap<String, String>();
		map.put("k1","v1");
		map.put("k2","v2");
		map.put("k3","v3");
		try {
			Set set = map.entrySet();
			Iterator iter = set.iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry)iter.next();
				sb.append(entry.getKey() + ":" + entry.getValue()).append("\r\n");
			}
			fos = new FileOutputStream(fileTemp);
			fos.write((content + "\r\n").getBytes("utf-8"));
			fos.write(sb.toString().getBytes("utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//读取文件里的内容
	public static void readFile(){
		fileTemp = filePath + fileName + ".txt";
		FileReader fd = null;
		BufferedReader br = null;
		String result = "";
		String read = "";
		try {
			fd = new FileReader(fileTemp);
			br = new BufferedReader(fd);
			while ((read = br.readLine()) != null) {
				result = result + read + "\r\n";
			}
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}if (fd != null) {
				try {
					fd.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
