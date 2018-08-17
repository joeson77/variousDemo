package proxy;

import java.lang.reflect.Method;

public class MyHandler implements MyInvocationHandler {

	private People people;
	
	public MyHandler(People people) {
		this.people = people;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		
		method.invoke(people, args);
		
		after();
		
		return null;
	}
	
	private void before(){
		System.out.println("我在吃猪蹄之前必须要洗手！");
	}
	
	private void after(){
		System.out.println("我在吃猪蹄之后必须要洗手！");
	}
}
