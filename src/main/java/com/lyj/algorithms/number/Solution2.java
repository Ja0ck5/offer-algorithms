package com.lyj.algorithms.number;

/**
 * �������� n����˳���ӡ���� 1 ������ n λ�������� �������� 3�����ӡ�� 1�� 2�� 3 һֱ�� 999
 * 
 * @author Ja0ck5
 *
 */
public class Solution2 {
	public static void main(String[] args) {
		Solution2 s2 = new Solution2();
		s2.printMaxOfNDigits(2);
	}

	public void printMaxOfNDigits(int n) {
		int[] array = new int[n];
		if (n <= 0)
			return;
		printArray(array, 0);
	}

	private void printArray(int[] array, int n) {
		//��ÿһλ�������� 0-9
		for (int i = 0; i < 10; i++) {
			if (n != array.length) {
				array[n] = i;
				printArray(array, n + 1);
			} else {
				boolean isFirstNo0 = false;
				for (int j = 0; j < array.length; j++) {
					if (array[j] != 0) {
						System.out.print(array[j]);
						if (!isFirstNo0)
							isFirstNo0 = true;
					} else {
						if (isFirstNo0)
							System.out.print(array[j]);
					}
				}
				System.out.println();
				return;
			}
		}
	}
}
