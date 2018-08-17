package demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Test {

	// 线程
	// public static void main(String argv[]) throws InterruptedException {
	// Thread t = new Thread(new Runnable() {
	// public void run() {
	// try {
	// Thread.sleep(2000);
	// } catch (InterruptedException e) {
	// throw new RuntimeException(e);
	// }
	// System.out.print("2");
	//
	// }
	// });
	// t.start();
	// t.join();
	// System.out.print("1");
	// }

	// swich
	// public static void main(String[] args) {
	// for (int i = 0; i < 2; i++) {
	// switch (i) {
	// case 0:
	// System.out.print(i);
	// case 1:
	// System.out.print(i);
	// break;
	// }
	// }
	// System.out.println("End");
	// }

	// 懒汉单例模式
	// private Test(){
	//
	// }
	//
	// private static Test test = null;
	//
	// private static Test getInstance(){
	// if (test == null) {
	// test = new Test();
	// }
	// return test;
	// }

	// 饿汉单例模式
	// private Test(){
	//
	// }
	//
	// private static final Test test = new Test();
	// private static Test getInstance(){
	// return test;
	// }
	public static void main(String[] args) {
//		for (int i = 0; i < 5; i++) {
//			System.out.println(i++);
//			if (i%3 == 0) {
//				break;
//			}
//		}
		
//		ArrayList<String> a = new ArrayList<String>();
//		a.add("Alpha");
//		a.add("Bravo");
//		a.add("Charlie");
//		a.add("Delta");
//		Iterator iter = a.iterator();
//		for (int j = 0; j < a.size(); j++) {
//			System.out.println(a.get(j));
//		}
		
		int a = 5;
		int b = -2;
		int c = a + b;
		System.out.println(c);
	}
}
