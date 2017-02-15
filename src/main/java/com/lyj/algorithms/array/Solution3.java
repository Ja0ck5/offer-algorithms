package com.lyj.algorithms.array;

/**
 * 调整数组顺序使奇数位于偶数前面输入一个整数数组， 实现一个函数来调整该函数数组中数字的顺序 使得所有奇数位于数组的前半部分，所有的偶数位于数组的后半部分。
 * 
 * @author Ja0ck5
 *
 */
public class Solution3 {

	public static void main(String args[]) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		Solution3 s3 = new Solution3();
		s3.sortOddBeforeEven(array);
		for (int item : array)
			System.out.println(item);
	}

	public void sortOddBeforeEven(int[] array) {
		if (array == null || array.length == 0)
			return;
		int start = 0;
		int end = array.length - 1;
		while (start < end) {
			//前后逼近
			//1  如果是奇数，则查找下一个看是否为偶数，是偶数则与后面的奇数调换
			while (start < end && !isEven(array[start])) {
				start++;
			}
			//2 如果是偶数，则查找下一个奇数，与前面的偶数调换 ------ 对应 //1
			while (start < end && isEven(array[end])) {
				end--;
			}
			//exchange
			if (start < end) {
				array[start] ^= array[end];
				array[end] ^= array[start];
				array[start] ^= array[end];
			}
		}
	}

	private boolean isEven(int n) {
		return n % 2 == 0;
	}

}
