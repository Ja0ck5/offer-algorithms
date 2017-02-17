package com.lyj.algorithms.array;

import java.util.Arrays;

/**
 * ��С�� k ������
 * 
 * ���� n ���������ҳ�������С�� k �������������� 4,5,1, 6,2,7,3,8 �� 8 �����֣������ٵ� 4 �������� 1,2,3,4.
 * 
 * 
 * ���ڶ������㷨���������ѡ�ʱ�临�Ӷ�ΪO(nlogk)
 * 
 * ����ÿ�������ʱ�临�Ӷ�ΪO(nlogn)��
 * 
 * �����ð������ʱ�临�Ӷ�ΪO(n*k)
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
		//��������
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
