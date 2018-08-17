package 多线程测试.模拟多线程抢票;

/**
 * 模拟多线程抢票系统
 * @author 厉昀键
 * Created on 2017年12月19日
 * 类说明
 *
 */
public class GrabTicket implements Runnable {
	private int time = 50;
	private int ticket = 5;
	private int i = 6;
	private String str ="";
	@Override
	public void run() {
		if (ticket > 0) {
			synchronized (str) {  //参数str的作用是对象锁 表示同一时间执行此str代码块的只能有一个线程
				if (ticket > 0 ) {
					System.out.println(Thread.currentThread().getName() + " 抢到第" + (i-ticket) + "张票，还剩" + (ticket-1) + "张票");
					ticket--;
				}
			}
		}else {
			System.out.println("您来晚了，票已售完");
		}
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
