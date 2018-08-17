package copeIO;

import java.io.File;

public class Delete {
	public static void main(String[] args) {
		File file = new File("/Users/liyunjian/Users/liyunjian/Downloads/eclipseProcedure/dubbo-customer01/src/main/webapp/html");
	    File[] fileList = file.listFiles();
	    for (File file2 : fileList) {
			file2.delete();
		}
	}
}
