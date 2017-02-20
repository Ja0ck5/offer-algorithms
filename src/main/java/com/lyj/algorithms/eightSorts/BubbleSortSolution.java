package com.lyj.algorithms.eightSorts;

import java.util.Arrays;

public class BubbleSortSolution {
	
	public static void bubbleSort(int[] a){
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length-1-i; j++) {
				if(a[j] > a[j+1]){
					a[j] ^= a[j+1];
					a[j+1] ^= a[j];
					a[j] ^= a[j+1];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {2,5,4,3,1,7,9,8,6};
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}
}
