package com.lyj.algorithms.stack;

import java.util.Stack;

/**
 * ջ��ѹ�롢��������
 * 
 * ʵ�����ж��Ƿ�Ϊջ�ĺϷ��������
 * 
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������� ��Ϊ��ջ�ĵ������С�����ѹ��ջ���������־�����ȡ�
 * 
 * ����ѹջ����Ϊ 1�� 2�� 3�� 4��5.���� 4�� 5�� 3�� 2�� 1 ��ѹջ���ж�Ӧ��һ���������У��� 4�� 3�� 5�� 1�� 2 ȴ���ǡ�
 * 
 * @author Ja0ck5
 *
 */
public class Solution {
	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = { 4, 5, 3, 2, 1 };
		int[] array3 = { 4, 3, 5, 1, 2 };
//		System.out.println(Solution.isPopOrder(array1, array2));
//		System.out.println(Solution.isPopOrder(array1, array3));
		System.out.println(Solution.isPopOrder2(array1, array2));
		System.out.println(Solution.isPopOrder2(array1, array3));
	}

	public static boolean isPopOrder(int[] line1, int[] line2) {
		if (line1 == null || line2 == null) 
			return false;
		int point1 = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < line2.length; i++) {
			if (!stack.isEmpty() && stack.peek() == line2[i]) {
				stack.pop();
			} else {
				if (point1 == line1.length) {
					return false;
				} else {
					do {
						stack.push(line1[point1++]);
					} while (stack.peek() != line2[i] && point1 != line1.length);
					if (stack.peek() == line2[i])
						stack.pop();
					else
						return false;
				}
			}
		}
		return true;
	}

	/**
	 * �Ƽ�
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isPopOrder2(int[] s1, int[] s2) {
		if (s1.length == 0 || s2.length == 0)
			return false;
		Stack<Integer> s = new Stack<Integer>();
		// ���ڱ�ʶ�������е�λ��
		int mark = 0;
		for (int i = 0; i < s1.length; i++) {
			s.push(s1[i]);
			// ���ջ��Ϊ�գ���ջ��Ԫ�ص��ڵ�������
			while (!s.empty() && s.peek() == s2[mark]) {
				// ��ջ
				s.pop();
				// �������������һλ
				mark++;
			}
		}
		return s.empty();
	}
	
	
	public static boolean isPopOrder3(int[] s1,int[] s2){
		if(0 == s1.length || 0 == s2.length)
			return false;
		Stack<Integer> s = new Stack<Integer>();
		int mark = 0;
		for (int i = 0; i < s1.length; i++) {
			//�� s1 ��ջ���� ˳����ջ
			s.push(s1[i]);
			while(!s.empty() && s.peek() == s2[mark]){
				//��ջ
				s.pop();
				//��������ƶ�һλ
				mark++;
			}
		}
		return s.empty();
	}
}
