package 四种排序;

public class QuickSort {
/*
 * 快速排序
 * 1、算法概念。
	快速排序（Quicksort）是对冒泡排序的一种改进。由C. A. R. Hoare在1962年提出。
   2、算法思想。
	通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
	然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
   3、实现思路。
	①以第一个关键字 K 1 为控制字，将 [K 1 ,K 2 ,…,K n ] 分成两个子区，使左区所有关键字小于等于 K 1 ，
	右区所有关键字大于等于 K 1 ，最后控制字居两个子区中间的适当位置。在子区内数据尚处于无序状态。 
	②把左区作为一个整体，用①的步骤进行处理，右区进行相同的处理。（即递归）
	③重复第①、②步，直到左区处理完毕。
	4、实现代码。
	
	时间复杂度：O(n*log2n)
 * */
	
	public static void main(String[] args) {
		int[] arr = {5,9,2,1,4,7,5,8,3,6};
		int begin = 0;
		int end = 9;
		quickSort(arr, begin, end);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
	private static int partition(int[] arr,int begin,int end){
		int pivot = arr[begin];
		while (begin < end) {
			while (begin < end && arr[end] >= pivot) {
				end--;
			}
			arr[begin] = arr[end];
			while (begin < end && arr[begin] <= pivot) {
				begin++;
			}
			arr[end] = arr[begin];
		}
		arr[end] = pivot;
		return end;
	}
	
//	递归
	static void quickSort(int[] arr,int begin,int end){
		int pivot;
		if (begin >= end) {
			return;
		}
		pivot = partition(arr, begin, end);
		quickSort(arr, begin, pivot - 1);
		quickSort(arr, pivot + 1, end);
	}
	
	
	
//	第二种
	public static void main1(String[] args) {
		int[] array = {65,34,58,89,74,1,24};
		System.out.println("快速排序前的数组：");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
		System.out.println();
		sort(array, 0, array.length-1);//使用快速排序
		System.out.println("排序后的数组：");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
		System.out.println();
	}
	
//	进行一轮排序，array为排序数组，i，j为排序起始和结束位置，返回关键数据排序后索引
	private static int sortUnit(int[] array,int i,int j){
		int key = array[i];
		while (i < j) {
			//从后向前搜索比key小的值，比key小的放左边
			while (array[j]>=key && j>i) {
				j--;
			}
			//交换
			array[i]=array[j];
			//从后向前搜索比key大的值，比key打的放右边
			while (array[i]<=key && j>i) {
				i++;
			}
			//交换
			array[j]=array[i];
		}
		//当i=j时，一轮排序结束
		array[j]=key;
		//返回关键数据排序后索引
		return j;
	}
	
	//快速排序，递归调用
	public static void sort(int[] array,int low,int high){
		if (low >= high) {
			return;
		}
		//完成一轮排序
		int index = sortUnit(array, low, high);
		//对左边进行排序
		sort(array, low, index-1);
		//对右边进行排序
		sort(array, index+1, high);
	}
}
