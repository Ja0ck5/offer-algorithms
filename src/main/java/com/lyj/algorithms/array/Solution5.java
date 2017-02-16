package com.lyj.algorithms.array;

/**
 * 最小的 k 个数。
 * 
 * 输入 n 个整数，找出其中最小的 k 个数。例如输入 4,5,1, 6,2,7,3,8 这 8 个数字，则最少的 4 个数字是 1,2,3,4.
 * 
 * 
 * 基于堆排序算法，构建最大堆。时间复杂度为O(nlogk) 
 * 
 * 如果用快速排序，时间复杂度为O(nlogn)； 
 * 
 * 如果用冒泡排序，时间复杂度为O(n*k)
 * 
 * @author Ja0ck5
 *
 */
public class Solution5 {

/*	public static void getCustomMinNos(int[] array, int k) {
		if (null == array)
			return;
		int cnt = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] < array[j])
					if ((++cnt) >= array.length - k) {
						System.out.println(array[i]);
						cnt = 0;
						break;
					}
			}
		}
	}*/

	public static void main(String[] args) {
		int[] array = new int[] { 4, 5, 1, 6, 2, 7, 3, 8 };
//		Solution5.getCustomMinNos(array, 4);
	}
}
