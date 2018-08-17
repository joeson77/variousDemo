package proxy;

public class Test {
	public static void main(String[] args) throws Throwable {
		People people = (People)MyProxy.createProxyInstance(Test.class.getClassLoader(), People.class, new MyHandler(new ZhangSan()));
		people.eat();
	}
}
