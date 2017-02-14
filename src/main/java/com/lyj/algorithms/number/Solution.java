package com.lyj.algorithms.number;

/**
 * ����һ��������������������Ʊ�ʾ�� 1 �ĸ�����
 * ����� 9 ��ʾ�ɶ������� 1001���� 2 λ�� 1������������ 9��������� 2.
 * 
 * 
 * ��1�Ľ���ǰ����ұߵ�һ��1��ʼ������λ��ȡ���ˡ�
 * 
 * ���ʱ����������ٰ�ԭ���������ͼ�ȥ1֮��Ľ���������㣬
 * 
 * ��ԭ���������ұ�һ��1��һλ��ʼ����λ������0����1100&1011=1000.
 * 
 * 
 * 
 * ��һ��������ȥ1���ٺ�ԭ�����������㣬��Ѹ��������ұ�һ��1���0.
 * 
 * 
 * 
 * һ�������Ķ������ж��ٸ�1���Ϳ��Խ��ж��ٴ������Ĳ���
 * @author Ja0ck5
 *
 */
public class Solution {
	public static void main(String args[]) {
		Solution s = new Solution();
		System.out.println(s.numberOf1(9));
	}

	public int numberOf1(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n &= (n - 1);
		}
		return count;
	}
}
