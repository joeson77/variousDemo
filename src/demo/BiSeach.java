package demo;

/**
 * 二分查找法
 * @author 厉昀键
 * Created on 2017年12月4日
 * 类说明
 *
 */
public class BiSeach {
	public static int biSeach(int[] a,int elem){
		int n = a.length;
		int low = 0,high = n - 1,mid;
		while (low <= high) {
			mid = (low + high)/2;
			if (a[mid] == elem) {
				return mid + 1;
			} else if(a[mid] > elem){
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		return - 1;
	}
	
	public static void main(String[] args) {
		int[] test = {33,123,234,345,456,567,678,789,890,901};
		int elem = 234;
		int res = biSeach(test, elem);
		if (res != -1) {
			System.out.println("查找成功！该元素为第" + res + "个元素");
		} else {
			System.out.println("查找失败！该元素在数据组中不存在！");
		}
	}
}
