package copeIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {
	public static void main(String[] args) {
		File srcDir = new File("/Users/liyunjian/Downloads/java");
		if (!(srcDir.exists() && srcDir.isDirectory())) {
			try {
				throw new Exception("目录不存在");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		File[] files = srcDir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		});
		System.out.println(files.length);
		File destDir = new File("/Users/liyunjian/Downloads/jad");
		if (!destDir.exists()) {
			destDir.mkdir();
		}
		for (File f : files) {
			try {
				FileInputStream fis = new FileInputStream(f);
				String destFileName = f.getName().replaceAll("\\.java$", ".jad");
				FileOutputStream fos = new FileOutputStream(new File(destDir,destFileName));
				copy(fis,fos);
				fis.close();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private static void copy(InputStream ips,OutputStream ops) throws IOException{
		byte[] buf = new byte[1024];
		while (ips.read(buf) != -1) {
			ops.write(buf);
		}
	}
}
