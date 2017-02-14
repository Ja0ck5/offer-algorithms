package com.lyj.algorithms.number;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位进制数。 比如输入 3，则打印出 1、 2、 3 一直到 999
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
		//将每一位都看成是 0-9
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
