package proxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class MyProxy {
	static String rt = "\r\n";
	
	public static Object createProxyInstance(ClassLoader loader,Class intf,MyInvocationHandler h){
		//1、我们用字符串拼接的方法生成一个$Proxy0.java文件
		String proxyClass = get$Proxy0(intf);
		
		//2、把java文件写入到磁盘
		String fileName = "/Users/liyunjian/Users/liyunjian/Downloads/eclipseProcedure/Demo/src/proxy/$Proxy0.java";
		try {
			File file = new File(fileName);
			FileWriter fw = new FileWriter(file);
			fw.write(proxyClass);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		//3、我们必须要编译这个$Proxy0.java这个文件
		complierJava(fileName);
		
		//4、我们必须把这个编译成的.class文件加载到内存中
		MyClasssLoader loader1 = new MyClasssLoader("/Users/liyunjian/Users/liyunjian/Downloads/eclipseProcedure/Demo/src/proxy");
		try {
			Class<?> proxy0Class= loader1.findClass("$Proxy0");
//			proxy0Class.newInstance();
			Constructor m = proxy0Class.getConstructor(MyInvocationHandler.class);
			Object o = m.newInstance(h);
			
			return o;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static void complierJava(String fileName){
		try {
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
			Iterable units = fileManager.getJavaFileObjects(fileName);
			CompilationTask t = compiler.getTask(null, fileManager, null, null, null, units);
		t.call();
			fileManager.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String get$Proxy0(Class intf){
		
		Method[] methods = intf.getMethods();
		
		String proxyClass = "package proxy;" + rt 
				+ "import java.lang.reflect.Method;" + rt
				+ "public class $Proxy0 implements " + intf.getName() + "{" + rt
				+ "MyInvocationHandler h;" + rt
				+ "public $Proxy0(MyInvocationHandler h) {" +rt
				+ "this.h = h;" + rt + "}"
				+ getMethodStr(methods,intf) + rt + "}";
		return proxyClass;
	}
	
	private static String getMethodStr(Method[] methods,Class intf){
		
		String proxyMethod = "";
		
		for (Method method : methods) {
			proxyMethod += "public void " + method.getName() + "() throws Throwable {" +rt
					+ "Method md = " + intf.getName() + ".class.getMethod(\"" + method.getName()
					+ "\",new Class[]{});" +rt
					+"this.h.invoke(this,md,null);" + rt + "}" + rt;
		}
		
		return proxyMethod;
	}
}
