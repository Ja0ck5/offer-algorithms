package com.lyj.algorithms.eightSorts;

public class SelectSortSolution {
	public static void selectSort(int[] a) {
			if (null == a || a.length < 2)
				return;
			//将 a[i] 与 a[i+1...N] 中最小的元素交换
			for (int i = 0; i < a.length; i++) {
				int min = i;//最小元素索引
				for (int j = i + 1; j < a.length; j++) {
					if (a[j] < a[min])
						min = j;
				}
				//如果和当前元素索引 i 不相等，则交换 
				if (min!=i) {
					a[i]   ^= a[min];
					a[min] ^= a[i];
					a[i]   ^= a[min];
				}
			}
		}
	
	public static void main(String[] args) {
		int[] array = {2,5,4,3,1,7,9,8,6};
		selectSort(array);
		printArray(array);
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(" "+array[i]);
		}
	}
}

