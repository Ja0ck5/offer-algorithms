package com.lyj.algorithms.array;

/**
 * 数字在排序数组中出现的次数
 * 
 * 统计一个数字在排序数组中出现的次数。例如输入排序数组{1,2,3,3,3,3,3,4,5}和数字 3，由于 3 在这个数组中出现了 4 次，因此输出 4。
 * 
 * @author Ja0ck5
 *
 */
public class Solution9 {

	public static void main(String[] args) {
		Solution9 s = new Solution9();
		int[] array = { 1, 2, 3, 3, 3, 3, 4, 5 };
		System.out.println(s.getNumberOfK(array, 3));
	}

	private int getNumberOfK(int[] array, int k) {
		int n = 0;
		if (array != null) {
			int first = getFirstK(array, k, 0, array.length - 1);
			int last = getLastK(array, k, 0, array.length - 1);
			if (first > -1 && last > -1)
				n = last - first + 1;
		}
		return n;
	}

	private int getFirstK(int[] array, int k, int start, int end) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		int midData = array[mid];
		if (midData == k) {
			if ((mid > 0 && array[mid - 1] != k) || mid == 0)
				return mid;
			else
				end = mid - 1;
		} else if (midData > k)
			end = mid - 1;
		else
			start = mid + 1;
		return getFirstK(array, k, start, end);
	}

	private int getLastK(int[] array, int k, int start, int end) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		int midData = array[mid];
		if (midData == k) {
			if ((mid < array.length - 1 && array[mid + 1] != k) || mid == array.length - 1)
				return mid;
			else
				start = mid + 1;
		} else if (midData < k)
			start = mid + 1;
		else
			end = mid - 1;
		return getLastK(array, k, start, end);
	}
}
