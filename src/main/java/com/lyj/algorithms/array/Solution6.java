package com.lyj.algorithms.array;

/**
 * 连续子数组的最大和
 * 
 * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整 数组成一个子数组。
 * 
 * 求所有子数组的和的最大值。要求时间复杂度为 O(n)。
 * 
 * 输入的数组为{1， -2,3,10， -4,7,2， -5}，和最大的子数组为{3,10， -4,7,2}。
 * 
 * 
 * 算法时间复杂度O（n） 用total记录累计值，maxSum记录和
 * 
 * @author Ja0ck5
 *
 */
public class Solution6 {

	public int findGreatestSumOfSubArray(int[] array) {
		if (array.length == 0)
			return 0;
		else {
			int total = array[0], maxSum = array[0];
			for (int i = 1; i < array.length; i++) {
				if (total >= 0)
					total += array[i];
				else
					//如果前几项累计值负数，则认为有害于总和，total记录当前值
					total = array[i];
				if (total > maxSum)
					maxSum = total;
			}
			return maxSum;
		}

	}

	public static void main(String[] args) {
		Solution6 s6 = new Solution6();
		int[] array = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println(s6.findGreatestSumOfSubArray(array));
	}
}
