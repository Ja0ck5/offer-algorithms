package com.lyj.algorithms.array;

/**
 * 数组中的逆序对 在数组中的两个数字如果前一个数字大于后一个数字，则这两个数字组成 一个逆序对。输入一个数组，求出这个数组的逆序对的总数。
 * 
 * 例如在数组{7,5,6,4} 中，一共存在 5 个逆序对
 * 
 * 分别是（ 7,6）、（ 7、 5），（7、 4），（ 6、 4）， （ 5、 4）。
 * 
 * @author Ja0ck5
 *
 */
public class Solution8 {
	public static void main(String[] args) {
		Solution8 s8 = new Solution8();
		int[] array = { 7, 5, 6, 4 };
		System.out.println(s8.inversePairs(array));
	}

	public int inversePairs(int[] array) {
		if (array == null)
			return 0;
		int[] copy = array.clone();
		return mergeSort(array, copy, 0, array.length - 1);
	}

	private int mergeSort(int[] array, int[] result, int start, int end) {
		if (start == end) {
			result[start] = array[start];
			return 0;
		}
		 //分治
		int len = (end - start) / 2;
		// 左边  
		int left = mergeSort(result, array, start, start + len);
		// 右边 
		int right = mergeSort(result, array, start + len + 1, end);
		int lIdx = start + len;
		int rIdx = end;
		int cnt = 0;
		int p = rIdx;
		
		while (lIdx >= start && rIdx >= start + len + 1) {
			if (array[lIdx] > array[rIdx]) {
				result[p--] = array[lIdx--];
				cnt += rIdx - start - len;
			} else {
				result[p--] = array[rIdx--];
			}
		}
		
		for (int i = lIdx; i >= start; i--)
			result[p--] = array[i];
		for (int j = rIdx; j >= start + len + 1; j--)
			result[p--] = array[j];
		
		return left + right + cnt;
	}
}
