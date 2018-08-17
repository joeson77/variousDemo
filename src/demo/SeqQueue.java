package demo;

public class SeqQueue implements Queue {
	final int defaultSize = 10;
	int begin;
	int end;
	Object[] queue;
	int maxQueueSize;
	
	public SeqQueue() {
		initiate(defaultSize);
	}
	public SeqQueue(int sz){
		initiate(sz);
	}
	
	public void initiate(int sz){
		maxQueueSize = sz;
		begin = 0;
		end = 0;
		queue = new Object[sz];
	}

	@Override
	public void EnQueue(Object obj) throws Exception {
		if (end == maxQueueSize) {
			throw new Exception("队列已满！");
		}
		queue[end] = obj;
		end++;
	}

	@Override
	public Object DeQueue() throws Exception {
		if (end == 0) {
			throw new Exception("队列已空！");
		}
		end--;
		return queue[begin++];
	}

	@Override
	public Object QueueFront() throws Exception {
		if (end == 0) {
			throw new Exception("队列已空！");
		}
		return queue[begin];
	}

	@Override
	public boolean notEmpty() {
		return (end > 0);
	}

}
