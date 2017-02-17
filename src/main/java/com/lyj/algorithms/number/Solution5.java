package com.lyj.algorithms.number;

/**
 * ����
 * 
 * ���ǰ�ֻ�������� 2,3,�� 5 �ĳ�Ϊ������
 * 
 * ������������������1�ǳ������������Ա�ʾΪ���޸�2��3��5�ĳ˻�
 * 
 * �󰴴�С�����˳��ĵ� 1500 ������������ 6�� 8 ���ǳ����� �� 14���ǣ���Ϊ���������� 7.ϰ�������ǰ� 1 ������һ��������
 * 
 * @author Ja0ck5
 *
 */
public class Solution5 {

	public int getUglyNumber(int n) {
		if (n < 0)
			return 0;
		int[] uglyArray = new int[n];
		uglyArray[0] = 1;
		int ft2 = 1;
		int ft3 = 1;
		int ft5 = 1;
		for (int i = 1; i < uglyArray.length; i++) {
			int min = min(ft2 * 2, ft3 * 3, ft5 * 5);
			uglyArray[i] = min;
			while (ft2 * 2 <= min)
				ft2++;
			while (ft3 * 3 <= min)
				ft3++;
			while (ft5 * 5 <= min)
				ft5++;
		}
		return uglyArray[n - 1];
	}

	private int min(int i, int j, int k) {
		int min = (i < j) ? i : j;
		return (min < k) ? min : k;
	}

}
