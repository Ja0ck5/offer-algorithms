package com.lyj.algorithms.array;

/**
 * ��С�� k ������
 * 
 * ���� n ���������ҳ�������С�� k �������������� 4,5,1, 6,2,7,3,8 �� 8 �����֣������ٵ� 4 �������� 1,2,3,4.
 * 
 * 
 * ���ڶ������㷨���������ѡ�ʱ�临�Ӷ�ΪO(nlogk) 
 * 
 * ����ÿ�������ʱ�临�Ӷ�ΪO(nlogn)�� 
 * 
 * �����ð������ʱ�临�Ӷ�ΪO(n*k)
 * 
 * @author Ja0ck5
 *
 */
public class Solution5 {

/*	public static void getCustomMinNos(int[] array, int k) {
		if (null == array)
			return;
		int cnt = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] < array[j])
					if ((++cnt) >= array.length - k) {
						System.out.println(array[i]);
						cnt = 0;
						break;
					}
			}
		}
	}*/

	public static void main(String[] args) {
		int[] array = new int[] { 4, 5, 1, 6, 2, 7, 3, 8 };
//		Solution5.getCustomMinNos(array, 4);
	}
}
