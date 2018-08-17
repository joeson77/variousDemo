package demo;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class TestObj{
	private static int i = 0;
	private static void inc() throws InterruptedException{
		TimeUnit.MILLISECONDS.sleep(1);
		i++;
	}
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
			new Thread(()->{
				try {
					inc();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}
		TimeUnit.SECONDS.sleep(2);
		System.out.println("------" + i + "-------");
	}
}

