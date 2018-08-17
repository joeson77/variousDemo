package 四种排序;

public class Test {
	
	public static void main(String[] args) {
		int[] num = {5,9,2,1,4,7,5,8,3,6};
		int low = 0;
		int high = num.length-1;
		quickSort(num, low, high);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+" ");
		}
		System.out.println();
		
		int[] arrs = {5,9,2,1,4,7,5,8,3,6};
		selectSort(arrs);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+" ");
		}
		System.out.println();
		
		
		int[] arrsInsert = {5,9,2,1,4,7,5,8,3,6};
		insertSort(arrsInsert);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+" ");
		}
		System.out.println();
		
		int[] arrsBubble = {5,9,2,1,4,7,5,8,3,6};
		insertSort(arrsBubble);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+" ");
		}
		System.out.println();
	}
	
	//时间复杂度：nlog2n,空间复杂度:nlog2n
	public static void quickSort(int[] arrs,int low,int high){
		int start = low;
		int end = high;
		int flag = arrs[low];
		int temp;
		while (start < end) {
			while (start < end && arrs[end] >= flag) {
				end--;
			}
			if (start < end && arrs[end] < flag) {
				temp = arrs[start];
				arrs[start] = arrs[end];
				arrs[end] = temp;
			}
			while (start < end && arrs[start] <= flag) {
				start++;
			}
			if (start < end && arrs[start] > flag) {
				temp = arrs[start];
				arrs[start] = arrs[end];
				arrs[end] = temp;
			}
		}
		if (start > low) {
			quickSort(arrs, low, start-1);
		}
		if (end < high) {
			quickSort(arrs, end+1, high);
		}
	}
	
	//时间复杂度:n2,空间复杂度1
	public static void selectSort(int[] arrs){
		int min;
		int flag = -1;
		int temp;
		for (int i = 0; i < arrs.length; i++) {
			min = arrs[i];
			for (int j = i; j < arrs.length; j++) {
				if (arrs[j] < min) {
					flag = j;
				}
			}
			temp = arrs[i];
			arrs[i] = arrs[flag];
			arrs[flag] = temp;
		}
	}
	
	//时间复杂度：n2，空间复杂度:1
	public static void insertSort(int[] arrs){
		int insertNode;
		int j;
		for (int i = 1; i < arrs.length; i++) {
			j = i - 1;
			insertNode = arrs[i];
			while (j > 0 && arrs[j] > insertNode) {
				arrs[j+1] = arrs[j];
				j--;
			}
			arrs[j+1] = insertNode;
		}
	}
	
	//时间复杂度：n2，空间复杂度：1
	public static void bubble(int[] arrs){
		int temp;
		for (int i = 0; i < arrs.length; i++) {
			for (int j = 0; j < arrs.length-i-1; j++) {
				if (arrs[j] > arrs[j+1]) {
					temp = arrs[j];
					arrs[j] = arrs[j+1];
					arrs[j+1] = temp;
				}
			}
		}
	}
}
