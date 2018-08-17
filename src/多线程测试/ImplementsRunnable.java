package 多线程测试;

/**
 * 多线程集成runnable借口
 * @author 厉昀键
 * Created on 2017年12月19日
 * 类说明
 *
 */
public class ImplementsRunnable implements Runnable {
	private int ticket = 10; 
	public ImplementsRunnable() {
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "卖票:" + (this.ticket--));
		}
	}
	
}
