package copeIO;

import java.io.File;

/**
 * 遍历文件夹中的子文件夹及文件
 * @author 厉昀键
 * Created on 2017年12月4日
 * 类说明
 * 
 */
public class ListFile {
	private static int filelevel;

	public static void main(String[] args) {
		readFile("/Users/liyunjian/Downloads/TNTforge");
	}

	public static String createPrintStr(String name, int level) {
		String printStr = "";
		for (int i = 0; i < level; i++) {
			printStr = printStr + "        ";
		}
		printStr = printStr + "--- " + name;
		return printStr;
	}

	public static void readFile(String dirPath) {
		File file = new File(dirPath);
		File[] list = file.listFiles();
		for (File f : list) {
			if (f.isDirectory()) {
				System.out.println(createPrintStr(f.getName(), filelevel));
				filelevel++;
				readFile(f.getPath());
				filelevel--;
			} else {
				System.out.println(createPrintStr(f.getName(), filelevel));
			}
		}
	}
}
