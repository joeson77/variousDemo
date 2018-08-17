package 守护线程demo;

public class Test {
	public static void main(String[] args) {
		Thread MyCommon = new MyCommon();
		Thread MyDaemon = new Thread(new MyDaemon());
		//设置守护进程且在线程开启前设置
		MyDaemon.setDaemon(true);
		MyDaemon.start();
		MyCommon.start();
	}
}
