package demo;

public class TestSeqQueue {
	public static void main(String[] args) {
		SeqQueue myQueue = new SeqQueue();
		int test[] = {1,3,5,7,9};
		int n = 5;
		try {
			for (int i = 0; i < n; i++) {
				myQueue.EnQueue(new Integer(test[i]));
			}
			System.out.println("当前队列尾元素为：" + myQueue.end);
			System.out.println("当前出队列顺序为：");
			while (myQueue.notEmpty()) {
				System.out.println(myQueue.DeQueue());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
