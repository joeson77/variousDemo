package demo;

//无需数组遍历查找
public class SeqSeach {
	public static int seqSeach(int[] a,int elem){
		int n = a.length;
		int i = 0;
		while (i < n && a[i] != elem) {
			i++;
		}
		if (i == n) {
			return - 1;
		}else{
			return i + 1;
		}
	}
	
	public static void main(String[] args) {
		int[] test = {123,456,789,234,567,890,345,678,901,33};
		int elem = 234;
		int res = seqSeach(test, elem);
		if (res != -1) {
			System.out.println("查找成功！该元素为第" + res + "个元素");
		} else {
			System.out.println("查找失败！该元素在该数组中不存在！");
		}
	}
}
