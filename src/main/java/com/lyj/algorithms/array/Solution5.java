package com.lyj.algorithms.array;

import java.util.Arrays;

/**
 * 最小的 k 个数。
 * 
 * 输入 n 个整数，找出其中最小的 k 个数。例如输入 4,5,1, 6,2,7,3,8 这 8 个数字，则最少的 4 个数字是 1,2,3,4.
 * 
 * 
 * 基于堆排序算法，构建最大堆。时间复杂度为O(nlogk)
 * 
 * 如果用快速排序，时间复杂度为O(nlogn)；
 * 
 * 如果用冒泡排序，时间复杂度为O(n*k)
 * 
 * @author Ja0ck5
 *
 */
public class Solution5 {
	public static void main(String[] args) {
		Solution5 s5 = new Solution5();
		int[] array = { 4, 5, 1, 6, 2, 7, 3, 8 };
		s5.getLeastNumbers(array, 3);
	}

	public void getLeastNumbers(int[] array, int k) {
		if (array == null || k < 0 || k > array.length)
			return;
		int[] kArray = Arrays.copyOfRange(array, 0, k);
		buildMaxHeap(kArray);
		//构建最大堆
		for (int i = k; i < array.length; i++) {
			if (array[i] < kArray[0]) {
				kArray[0] = array[i];
				maxHeap(kArray, 0);
			}
		}
		for (int i = kArray.length-1; i >=0; i--)
			System.out.println(kArray[i]);
	}

	private void maxHeap(int[] kArray, int i) {
		int left = 2 * i;
		int right = left + 1;
		int largest = 0;
		if (right < kArray.length && kArray[left] > kArray[i])
			largest = left;
		else
			largest = i;
		if (right < kArray.length && kArray[right] > kArray[largest])
			largest = right;
		if (largest != i) {
			kArray[i] +=kArray[largest];
			kArray[largest] = kArray[i] - kArray[largest];
			kArray[i] -= kArray[largest];
			maxHeap(kArray, largest);
		}
	}

	private void buildMaxHeap(int[] kArray) {
		for (int i = kArray.length / 2; i >= 0; i--)
			maxHeap(kArray, i);
	}
}
