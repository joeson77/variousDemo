package 四种排序;

public class SelectSort {
/*
 * 第一次从下标为0的开始下标为0的这个数与后面的n-1个进行比较；
 * 找出最小或者最大的放在下标为0的这个位置；
 * 第二次从下标为1的开始比较；
 * 查询剩下的最大或者最小值；放在 下标为1的位置；以此类推；直到排序完成
 * 
 * 时间复杂度：O(n2：n的平方)
 * */
	
	public static void main(String[] args) {
		int[] arr = {5,9,2,1,4,7,5,8,3,6};
		selectSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	private static int[] selectSort(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
		return arr;
	}
}
