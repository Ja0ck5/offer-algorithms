package com.lyj.algorithms.array.test;

import java.util.Arrays;

public class Solution14 {

	/**
	 * 
	 * @param a
	 *            数组
	 * @param n
	 *            数组长度
	 * @return
	 */
	public static int[] findSegment(int[] a, int n) {
		if (null == a || 1 >= n)
			return new int[] { 0, 0 };

		boolean[] mark = new boolean[n];
		
		//取右 right
		int max = a[0];
		for (int i = 1; i < n; i++) {
			if(max > a[i])
				mark[i] = true;
			max = max < a[i] ? a[i] : max;
		}
		
		int right = -1;
		for (int i = 0; i < n; i++) {
			right = mark[i] ? i : right;
			mark[i] = false;
		}
		
		//取左
		int min = a[n-1];
		for (int i = n-2; i >=0 ; i--) {
			if(min < a[i])
				mark[i] = true;
			min = min > a[i] ?  a[i] : min;
		}
		
		int left = n;
		for (int i = n-1; i >=0; i--)
			left = mark[i] ? i : left;
		
		if(left == n){
			left = 0;
			right = 0;
		}
		
		return new int[]{left,right};
	}
	
	public static void main(String[] args) {
		int[] a = { 1, 4, 6, 5, 9, 10 };
		System.out.println(Arrays.toString(findSegment(a, a.length)));
	}

}
