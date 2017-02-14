package com.lyj.algorithms.array;

/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ����������������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ 1.
 * 
 * @author Ja0ck5
 *
 */
public class Solution1 {

	public Integer findMinInRotatedArray(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		
		int p1 = 0;// ��ǰ������
		int p2 = array.length - 1;// �Ӻ���ǰ��
		int min = array[p1];// ���û������ת��ֱ�ӽ�array[0]��ֵ���أ�
		int mid = 0;
		// �����鷢����ת�ˣ�
		while (array[p1] >= array[p2]) {
			// ������ָ���ߵ����ŵ�λ��ʱ��p2������С����
			if (p2 - p1 == 1) {
				min = array[p2];
				break;
			}
			mid = (p1 + p2) / 2;
			// ����м�λ�õ����ȵ���p1λ�õ����ֵ���P2λ�õ���
			if (array[p1] == array[mid] && array[p2] == array[mid]) {
				min = minInorder(array, p1, p2);
			}
			if (array[p1] <= array[mid])// ���м�λ�õ���λ������1����p1�ߵ�mid��λ��
			{
				p1 = mid;
			} else if (array[p2] >= array[mid])// ���м�λ�õ���λ������2����p2�ߵ�mid��λ��
			{
				p2 = mid;
			}
		}
		return min;
	}

	private int minInorder(int[] array, int p1, int p2) {
		int min = array[p1];
		for (int i = p1 + 1; i <= p2; i++) {
			if (min > array[i])
				min = array[i];
		}
		return min;
	}

	public static void main(String[] args) {
		Solution1 s1 = new Solution1();
		// int[] array={1,1,1,2,0};
		int[] array = { 3, 4, 5, 1, 2 };
		// int[] array={1,0,1,1,1};
		System.out.println(s1.findMinInRotatedArray(array));
	}
}
