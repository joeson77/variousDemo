package 四种排序;

public class Demo {
	
	//插入排序
	public static void insertSort(int[] arrs){
		for (int i = 1; i < arrs.length; i++) {
			int insertNode = arrs[i];
			int j;
			j = i - 1;
			while (j >= 0 && arrs[j] > insertNode) {
				arrs[j+1] = arrs[j];
				j--;
			}
			arrs[j+1] = insertNode;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		int[] arrs = {12,20,5,16,15,1,30,45,23,9};
		insertSort(arrs);
		for (int i = 0; i < arrs.length; i++) {
			System.out.print(arrs[i] + " ");
		}
	}
}
