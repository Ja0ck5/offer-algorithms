package com.lyj.algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ������ s����ӡ�����к�Ϊ s �������������У����ٺ�����������
 * 
 * �������� 15������ 1+2+3+4+5=4+5+6=7+8=15�����Խ����ӡ��
 * 
 * 3���������� 1-5�� 4-6���� 7-8.
 * 
 * @author Ja0ck5
 *
 *
 *         ������������ small �� big �ֱ��ʾ���е���Сֵ�����ֵ�����Ȱ� small ��ʼ��Ϊ 1��big ��ʼ��Ϊ 2�������
 *         small �� big �����еĺʹ��� s�����ǿ��Դ�������ȥ����С��ֵ��Ҳ�������� small ��ֵ������� small �� big
 *         �����еĺ�С�� s�����ǿ������� big����������а�����������֡���Ϊ�����������Ҫ���������֣�����һֱ���� small
 *         ��(1+s)/2 Ϊֹ��
 * 
 *         �����Ϊ 9 ��������������Ϊ���������Ȱ� small ��ʼ��Ϊ 1��big ��ʼ��Ϊ 2����ʱ���� small �� big
 *         ֮��������ǣ�1��2}�����еĺ�Ϊ 3��С�� 9������������һ��Ҫ�����а�����������֡�
 *         ���ǰ� big ���� 1 ��� 3����ʱ����Ϊ��1,2,3}���������еĺ��� 6����ȻС�� 9��
 *         ���ǽ����������� big ��� 4������ small �� big ֮�������Ҳ��֮��ɣ�1, 2, 3, 4����
 *         �����еĺ� 10 ���� 9������Ҫɾȥȥ�����е�һЩ���֣� ������������ small ���2����ʱ�õ��������ǣ�2, 3, 4�������еĺ�E���� 9��
 *         �����ҵ��˵�һ����Ϊ 9 ���������У�������ӡ����������������������big���ظ�ǰ��Ĺ��̣������ҵ��ڶ�����Ϊ 9 ���������У�4��5}��
 */
public class Solution12 {
	public static List<List<Integer>> findContinuousSequence(int sum) {
		List<List<Integer>> result = new ArrayList<>();
		if (sum < 3) 
			return result;
		int small = 1;
		int big = 2;
		int mid = (1 + sum) / 2;
		int curSum = small + big;
		while (small < mid) {
			if (curSum == sum) {
				List<Integer> list = new ArrayList<>(2);
				for (int i = small; i <= big; i++) {
					list.add(i);
				}
				result.add(list);
			}
			while (curSum > sum && small < mid) {
				curSum -= small;
				small++;
				if (curSum == sum) {
					List<Integer> list = new ArrayList<>(2);
					for (int i = small; i <= big; i++) {
						list.add(i);
					}
					result.add(list);
				}
			}
			big++;
			curSum += big;
		}
		return result;
	}
}
