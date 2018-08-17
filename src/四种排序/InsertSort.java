package 四种排序;

public class InsertSort {
/*
 * 插入排序就是每一步都将一个待排数据按其大小插入到已经排序的数据中的适当位置，直到全部插入完毕。 
 * 插入排序方法分直接插入排序和折半插入排序两种，这里只介绍直接插入排序，折半插入排序留到“查找”内容中进行。 
 * 
 * 时间复杂度：O(n2：n的平法)
 * */
	
	public static void main(String[] args) {
		int[] arr = {5,9,2,1,4,7,5,8,3,6};
		insertSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	private static int[] insertSort(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0 ; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}else
					break;
			}
		}
		return arr;
	}
}
