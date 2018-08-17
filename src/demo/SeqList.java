package demo;

public class SeqList implements List {
	final int defaultSize = 10;
	int maxSize;
	int size;
	Object[] listArray;
	SeqList() {
		initiate(defaultSize);
	}
	SeqList(int size){
		initiate(size);
	}
	
	public void initiate(int sz) {
		maxSize = sz;
		size = 0;
		listArray = new Object[sz];
	}

	@Override
	public void insert(int i, Object obj) throws Exception {
		if (size == maxSize) {
			throw new Exception("线性表已满，无法插入！");
		}
		if (i > size) {
			throw new Exception("插入下标未知错误！");
		}
		for (int j = size; j > i; j--) {
			listArray[j] = listArray[j - 1];
		}
		listArray[i] = obj;
		size++;
	}

	@Override
	public Object delete(int i) throws Exception {
		if (size == 0) {
			throw new Exception("线性表已空，无法删除！");
		}
		if (i > size - 1) {
			throw new Exception("删除下标错误！");
		}
		Object it = listArray[i];
		for (int j = i; j < size - 1; j++) {
			listArray[i] = listArray[j + 1];
		}
		size--;
		return it;
	}

	@Override
	public void update(int i, Object obj) throws Exception {
		if (size == 0) {
			throw new Exception("线性表已空，无法替换！");
		}
		if (i > size + 1) {
			throw new Exception("替换下标位置错误！");
		}
		listArray[i] = obj;
	}

	@Override
	public Object getData(int i) throws Exception {
		if (size == 0) {
			throw new Exception("线性表已空，无法获取！");
		}
		if (i > size) {
			throw new Exception("获得下标位置错误！");
		}
		return listArray[i];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
}
