package 多线程测试.模拟多线程抢票;

/**
 * 模拟多线程抢票测试类
 * @author 厉昀键
 * Created on 2017年12月19日
 * 类说明
 *
 */
public class Test {
	public static void main(String[] args) {
		int people = 10;
		GrabTicket gt = new GrabTicket();
		Thread t[] = new Thread[people];
		for (int i = 0; i < people; i++) {
			t[i] = new Thread(gt,"编号为" + (int)((Math.random()*9+1)*100000) + "的同学");
			//(Math.random()*9+1) 为防止取到0
			t[i].start();
		}
	}
}
