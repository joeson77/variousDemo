package demo;

import java.util.Scanner;

/*
 * 给出如下定义：
 * 1.元素数组的子数组是由原始数组的连续元素块组成的数组。例如：如果一个数组array = [1,2,3	]，
 * 则该数组的子数组有[1],[2],[3],[1,2],[2,3],[1,2,3];[1,3]不是原始数组的子数组，因为
 * [1,3]在原始数组中不是连续的元素块。
 * 2.数组的和是其元素的总和。例如：array = [1,2,3]的和是6。
 * 
 * 任务：给出一个自定义数组A,求出"元素和为负数的子数组"的个数。
 * 输入：第一行输入自定义数组的长度n，第二行输入自定义数组的各元素a[i]，以空格隔开，
 * 各元素的数据类型为int。
 * 输出：元素求和sum为负数的子组数组的个数
 * 例如：输入
 * 5
 * 1 -2 4 -5 1
 * 输出
 * 9
 * */


public class Array {
	public static void main(String[] args) {
		System.out.println("您需要创建一个数字，请输入一个数字指定数组的长度：");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int array[] = new int[number];
		System.out.println("请输入" + number + "个数字，要求数字之和小于0且数字间用空格隔开:");
		for (int i = 0; i < array.length; i++) {
			array[i] = input.nextInt();
		}
		int total = 0;
		int sum = 0;
		for (int i = 0; i < number; i++) {
			for (int j = i; j < number; j++) {
				for (int k = i; k <= j; k++) {
					sum = sum + array[k];
				}
				if (sum < 0) {
					total++;
				}
			}
		}
		System.out.println(total);
	}
}
