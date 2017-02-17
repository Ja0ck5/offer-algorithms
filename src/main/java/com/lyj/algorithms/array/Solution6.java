package com.lyj.algorithms.array;

/**
 * ���������������
 * 
 * ����һ���������飬������������Ҳ�и�����������һ���������Ķ���� �����һ�������顣
 * 
 * ������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�Ϊ O(n)��
 * 
 * ���������Ϊ{1�� -2,3,10�� -4,7,2�� -5}��������������Ϊ{3,10�� -4,7,2}��
 * 
 * 
 * �㷨ʱ�临�Ӷ�O��n�� ��total��¼�ۼ�ֵ��maxSum��¼��
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
					//���ǰ�����ۼ�ֵ����������Ϊ�к����ܺͣ�total��¼��ǰֵ
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
