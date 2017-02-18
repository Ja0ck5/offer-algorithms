package com.lyj.algorithms.array;

import java.util.Arrays;

/**
 * �˿��Ƶ�˳��
 * 
 * ���˿���������� 5 ���ƣ��ж��ǲ���˳�ӣ����� 5 �����ǲ��������ġ�
 * 
 * 2-10 Ϊ���ֱ��� A Ϊ 1�� J Ϊ 11�� Q Ϊ12�� K Ϊ 13������С�����Կ�������� ���֡�
 * 
 * 
 * ��ֱ�۵ķ����ǰ���������ֵ��ע����ǣ����� 0 ���Ե����������֣����ǿ����� 0
 * ȥ���������еĿ�ȱ���������֮������鲻�������ģ������ڵ���������������ɸ����֣���ֻҪ�������㹻�ġ����Բ������������ֵĿ�ȱ���������ʵ���ϻ��������ġ�
 * �ٸ����ӣ���������֮��Ϊ{0��1��3��4��5}�� 1 �� 3 ֮���ȱ��һ�� 2���պ�������һ�� 0��Ҳ�������ǿ��԰������� 2 ȥ������ȱ��
 * 
 * ����������Ҫ�� 3 �����飺 ���Ȱ�����������ͳ�������� 0 �ĸ��������ͳ������֮�����������������֮��Ŀ�ȱ�����������ȱ������С�ڻ��ߵ��� 0
 * �ĸ�������ô���������������ģ���֮��������
 * 
 * ������ǻ���Ҫע��һ�㣺 ��������еķ� 0 �����ظ����֣�������鲻�������ġ������˿��Ƶ�������ʽ�������һ�����ﺬ�ж��ӣ��򲻿�����˳�ӡ�
 * 
 * @author Ja0ck5
 *
 */
public class Solution13 {
	public static boolean isContinuous(int[] nums) {
		if (nums == null || nums.length != 5)
			return false;
		// ��Ԫ�ؽ�������
		Arrays.sort(nums);
		int numberOfZero = 0;
		int numberOfGap = 0;
		for (int i = 0; i < nums.length && nums[i] == 0; i++)
			numberOfZero++;
		// ��һ����0Ԫ�ص�λ��
		int small = numberOfZero;
		int big = small + 1;
		while (big < nums.length) {
			if (nums[small] == nums[big])
				return false;

			numberOfGap += (nums[big] - nums[small] - 1);
			small = big;
			big++;

		}
		return numberOfGap <= numberOfZero;
	}

	public static void main(String[] args) {
		int[] numbers1 = { 1, 3, 2, 5, 4 };
		System.out.println(isContinuous(numbers1));
		int[] numbers2 = { 1, 3, 2, 6, 4 };
		System.out.println(isContinuous(numbers2));
		int[] numbers3 = { 0, 3, 2, 6, 4 };
		System.out.println(isContinuous(numbers3));
		int[] numbers4 = { 0, 3, 1, 6, 4 };
		System.out.println(isContinuous(numbers4));
		int[] numbers5 = { 1, 3, 0, 5, 0 };
		System.out.println(isContinuous(numbers5));
		int[] numbers6 = { 1, 3, 0, 7, 0 };
		System.out.println(isContinuous(numbers6));
		int[] numbers7 = { 1, 0, 0, 5, 0 };
		System.out.println(isContinuous(numbers7));
		int[] numbers8 = { 1, 0, 0, 7, 0 };
		System.out.println(isContinuous(numbers8));
		int[] numbers9 = { 3, 0, 0, 0, 0 };
		System.out.println(isContinuous(numbers9));
		int[] numbers10 = { 0, 0, 0, 0, 0 };
		System.out.println(isContinuous(numbers10));
		int[] numbers11 = { 1, 0, 0, 1, 0 };
		System.out.println(isContinuous(numbers11));
	}
}
