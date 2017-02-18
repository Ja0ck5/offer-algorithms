package com.lyj.algorithms.array;

/**
 * 数组中只出现一次的数字。
 * 
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。 找出这两个只出现一次的数字。要求时间复杂度是 O（n），空间复杂度为 O（ 1）；
 * 
 * @author Ja0ck5
 *
 */
public class Solution10 {
	public static void main(String[] args) {
		int[] array = { 2, 4, 3, 6, 3, 2, 5, 5 };
		Solution10 s10 = new Solution10();
		s10.findNumsAppearOnce(array);
	}

	public void findNumsAppearOnce(int[] array) {
		if (array == null)
			return;
		int n = 0;
		
		for (int i : array)
			n ^= i;
		
		int idx = findFirstBitIs1(n);
		
		int n1 = 0;
		int n2 = 0;
		for (int i : array) {
			if (isBit1(i, idx))
				n1 ^= i;
			else
				n2 ^= i;
		}
		System.out.println(n1);
		System.out.println(n2);
	}

	private int findFirstBitIs1(int n) {
		int idxBit = 0;
		while ((n & 1) == 0) {// 找到异或结果中，从右到左第一个不为0 的位，用于数组划分
			n = n >> 1;
			++idxBit;
		}
		return idxBit;
	}

	private boolean isBit1(int n, int idx) {
		n = n >> idx;
		return (n & 1) == 0;
	}

}
