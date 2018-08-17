package demo;

public interface Queue {
	public void EnQueue(Object obj) throws Exception;
	public Object DeQueue() throws Exception;
	public Object QueueFront() throws Exception;
	public boolean notEmpty();
}
