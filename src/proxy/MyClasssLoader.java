package proxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyClasssLoader extends ClassLoader {

	private File dir;
	
	public MyClasssLoader(String path) {
		dir = new File(path);
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		
		if (dir != null) {
			File clazzFile = new File(dir, name+".class");
			if (clazzFile.exists()) {
				FileInputStream input = null;
				try {
					input = new FileInputStream(clazzFile);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					byte[] buffer = new byte[1024];
					int len;
					while((len = input.read(buffer)) != -1){
						baos.write(buffer,0,len);
					}
					return defineClass("proxy."+name,baos.toByteArray(),0,baos.size());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return super.findClass(name);
	}
	
}
