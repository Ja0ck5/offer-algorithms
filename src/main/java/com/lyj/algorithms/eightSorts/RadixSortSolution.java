package com.lyj.algorithms.eightSorts;

import java.util.Arrays;

public class RadixSortSolution {
	public static void main(String[] args) {
		int[] array = new int[] { 1200, 292, 121, 72, 233, 44, 12 };
		radixSort(array, 4);
		System.out.println("排序后的数组：" + Arrays.toString(array));
	}

	public static void radixSort(int[] a, int d) // d表示最大的数有多少位
	{
		int k = 0;
		int n = 1;
		int m = 1; // 控制键值排序依据在哪一位
		int radix = 10;
		int[][] bucket = new int[10][a.length]; // 数组的第一维表示可能的余数0-9
		int[] order = new int[10]; // 数组order[i]用来表示该位是i的数的个数
		while (m <= d) {
			
			for (int i = 0; i < a.length; i++) {
				//Least Significant Digit first
				int lsd = ((a[i] / n) % radix);
				bucket[lsd][order[lsd]] = a[i];
				order[lsd]++;
			}
			
			for (int i = 0; i < radix; i++) {
				if (order[i] != 0)
					for (int j = 0; j < order[i]; j++) {
						a[k] = bucket[i][j];
						k++;
					}
				order[i] = 0;
			}
			
			n *= radix;
			k = 0;
			m++;
		}
	}
}
