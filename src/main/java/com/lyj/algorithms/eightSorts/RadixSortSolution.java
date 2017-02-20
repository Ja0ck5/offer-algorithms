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
		/**
		 * 表示桶的每一行也就是每一位存放的个数
		 */
		int[] order = new int[10]; 
		while (m <= d) {

			for (int i = 0; i < a.length; i++) {
				// Least Significant Digit first
				int lsd = ((a[i] / n) % radix);
				bucket[lsd][order[lsd]] = a[i];
				order[lsd]++;
			}
			//将桶中的数值保存会原来的数组中
			for (int i = 0; i < radix; i++) {
				if (order[i] != 0)
					for (int j = 0; j < order[i]; j++) {
						a[k] = bucket[i][j];
						k++;
					}
				order[i] = 0;//拷贝完成清除记录的个数，设为0
			}

			n *= radix;
			k = 0; //k值记录拷贝数据到原有数组中的位置，拷贝完成恢复0
			m++;
		}
	}
}
