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
		while ((n & 1) == 0) {// �ҵ�������У����ҵ����һ����Ϊ0 ��λ���������黮��
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
