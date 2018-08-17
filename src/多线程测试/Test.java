package 多线程测试;

/**
 * 多线程测试类
 * @author 厉昀键
 * Created on 2017年12月19日
 * 类说明
 *
 */
public class Test {
	public static void main(String[] args) {
		ImplementsRunnable ds1 = new ImplementsRunnable();
		Thread t1 = new Thread(ds1, "张三");
		Thread t2 = new Thread(ds1, "李四");
		t1.start();
		t2.start();
	}
}
