package com.lyj.algorithms.array;

import java.util.Arrays;

/**
 * ��һ���������飬���дһ���������ҳ�����m��n��ֻҪ��m��n֮���Ԫ���ź������������������ġ�ע�⣺n-mӦ��ԽСԽ�ã�Ҳ����˵��
 * �ҳ�����������������С�
 * ����һ��int����A������Ĵ�Сn���뷵��һ����Ԫ�飬�����������е������յ㡣(ԭ����λ�ô�0��ʼ���,��ԭ�������򣬷���[0,0])��
 * ��֤A��Ԫ�ؾ�Ϊ��������
 * 
 * @author Ja0ck5
 *
 */
public class Solution14 {
	/**
	 * 
	 * @param a
	 * @param n
	 *            �����С
	 * @return
	 */
	public static int[] findSegment(int[] a, int n) {

		if (a == null || n == 1)
			return new int[] { 0, 0 };
		boolean[] marks = new boolean[n];

		int max = a[0];
		for (int i = 1; i < n; i++) {
			if (max > a[i])
				marks[i] = true;
			max = max < a[i] ? a[i] : max;
		}

		int right = -1;
		for (int i = 0; i < n; i++) {
			right = marks[i] ? i : right;
			marks[i] = false;
		}

		int min = a[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (min < a[i])
				marks[i] = true;
			min = min > a[i] ? a[i] : min;
		}

		int left = n;
		for (int i = n - 1; i >= 0; i--)
			left = marks[i] ? i : left;

		if (left == n) {
			left = 0;
			right = 0;
		}
		return new int[] { left, right };
	}

	public static void main(String[] args) {
		int[] a = { 1, 4, 6, 5, 9, 10 };
		System.out.println(Arrays.toString(findSegment(a, a.length)));
	}
}
