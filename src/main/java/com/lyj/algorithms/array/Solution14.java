package com.lyj.algorithms.array;

import java.util.Arrays;

/**
 * 有一个整数数组，请编写一个函数，找出索引m和n，只要将m和n之间的元素排好序，整个数组就是有序的。注意：n-m应该越小越好，也就是说，
 * 找出符合条件的最短序列。
 * 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的起点和终点。(原序列位置从0开始标号,若原序列有序，返回[0,0])。
 * 保证A中元素均为正整数。
 * 
 * @author Ja0ck5
 *
 */
public class Solution14 {
	/**
	 * 
	 * @param a
	 * @param n
	 *            数组大小
	 * @return
	 */
	public static int[] findSegment(int[] a, int n) {

		if (a == null || n == 1)
			return new int[] { 0, 0 };
		boolean[] marks = new boolean[n];

		int max = a[0];
		for (int i = 1; i < n; i++) {
			if (max > a[i])
				marks[i] = true;
			max = max < a[i] ? a[i] : max;
		}

		int right = -1;
		for (int i = 0; i < n; i++) {
			right = marks[i] ? i : right;
			marks[i] = false;
		}

		int min = a[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (min < a[i])
				marks[i] = true;
			min = min > a[i] ? a[i] : min;
		}

		int left = n;
		for (int i = n - 1; i >= 0; i--)
			left = marks[i] ? i : left;

		if (left == n) {
			left = 0;
			right = 0;
		}
		return new int[] { left, right };
	}

	public static void main(String[] args) {
		int[] a = { 1, 4, 6, 5, 9, 10 };
		System.out.println(Arrays.toString(findSegment(a, a.length)));
	}
}
