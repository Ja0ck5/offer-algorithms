package com.lyj.algorithms.eightSorts;

import java.util.Arrays;

public class MergeSortSolution {
	
	public static void mergeSort(int[] a, int lo, int hi) {
		if (hi <= lo) return;
		int mid = (lo + hi) / 2;
		mergeSort(a, lo, mid);// 左边排序
		mergeSort(a, mid + 1, hi);// 右边排序
		merge(a, lo, mid, hi);// 归并结果
	}
	
	//将 a[lo..mid] 与 a[mid+1..hi] 合并 
	private static void merge(int a[], int lo, int mid, int hi) {
		// 归并所需的辅助数组
		int[] aux = new int[hi - lo + 1];
		// 辅助数组索引
		int k = 0;
		int i = lo;// 左指针
		int j = mid + 1;// 右指针
		// 把较小的数先移到新数组中(每個子數組也反復執行)
		while (i <= mid && j <= hi) {
			if (a[i] < a[j])
				aux[k++] = a[i++];
			else
				aux[k++] = a[j++];
		}
		// 把左边剩余的数移入数组  
		while (i <= mid) 
			aux[k++] = a[i++];

		// 把右边剩余的数移入数组  
		while (j <= hi)
			aux[k++] = a[j++];
		
		// 注意这里是lo + t  (即不同的子數組的起始位置----左指针)  把新数组中的数覆盖  原数组
		for (int t = 0; t < aux.length; t++)
			a[lo + t] = aux[t];
	}
	
	 public static void main(String[] args) {
	        int a[] = { 2, 6, 1, 4, 3, 9, 5, 8, 7 };
	        mergeSort(a, 0, a.length - 1);
	        System.out.println("排序结果：" + Arrays.toString(a));
	    }
}
