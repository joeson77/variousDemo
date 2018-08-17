package 四种排序;

public class BubbleSort {
/*
 * 首先，把N个数里最小的个数放到下标为0的位置上（str[0]）
   通过将下标为0的数（str[0]）与剩下其余9个数进行对比交换（将较少者放置在下标为0的位置上），
   就可以得到这N个数最小的那个
   N个数最小的那位确定后，接下来就要找剩下9个数最小的那个。
   因为已经确定出一个最小的数，所以就不要动str[0]，直接从str[1]开始，
   与剩下的(N-2)个数对比交换，找出(N-1)个数中最小的那位放到下标为1（str[1]）的位置上
   继续按照这个思路就可以将这十个数变成有序的（从小到大）的数组
   
   时间复杂度：O(n2：n的平方)
 * */
	
	public static void main(String[] args) {
		int[] arr = {5,9,2,1,4,7,5,8,3,6};
		bubbleSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	private static int[] bubbleSort(int arr[]){
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr;
	}
}
