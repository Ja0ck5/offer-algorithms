package com.lyj.algorithms.array;

/**
 * ������ֻ����һ�ε����֡�
 * 
 * һ�����������������������֮�⣬���������ֶ����������Ρ� �ҳ�������ֻ����һ�ε����֡�Ҫ��ʱ�临�Ӷ��� O��n�����ռ临�Ӷ�Ϊ O�� 1����
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
		int number = 0;
		for (int i : array)
			number ^= i;
		int index = findFirstBitIs1(number);
		int number1 = 0;
		int number2 = 0;
		for (int i : array) {
			if (isBit1(i, index))
				number1 ^= i;
			else
				number2 ^= i;
		}
		System.out.println(number1);
		System.out.println(number2);
	}

	private int findFirstBitIs1(int number) {
		int indexBit = 0;
		while ((number & 1) == 0) {
			number = number >> 1;
			++indexBit;
		}
		return indexBit;
	}

	private boolean isBit1(int number, int index) {
		number = number >> index;
		return (number & 1) == 0;
	}

}
