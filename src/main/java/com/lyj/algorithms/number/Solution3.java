package com.lyj.algorithms.number;

import java.util.Arrays;
import java.util.Stack;

/**
 * ���� min ������ջ ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�min������ �ڸ�ջ�У�����min��
 * push��pop�¶�ʱ�临�Ӷȶ���O(1)
 * 
 * ˼·����һ��ջdata�������ݣ�������һ��ջmin����������ջ��С���� ���磬data��������ջ��5, 4, 3, 8, 10, 11, 12, 1
 * ��min������ջ��5, 4, 3��no,no, no, no, 1
 * 
 * no����˴β���ջ ÿ����ջ��ʱ�������ջ��Ԫ�ر�min�е�ջ��Ԫ��С���������ջ��������ջ��
 * 
 * @author Ja0ck5
 *
 */
public class Solution3 {
	Stack<Integer> data = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();
	Integer temp = null;

	public void push(int node) {
		if (temp != null) {
			if (node <= temp) {
				temp = node;
				min.push(node);
			}
			data.push(node);
		} else {
			temp = node;
			data.push(node);
			min.push(node);
		}
	}

	public void pop() {
		int num = data.pop();
		int num2 = min.pop();
		if (num != num2) {
			min.push(num2);
		}
	}

	public int top() {
		int num = data.pop();
		data.push(num);
		return num;
	}

	public int min() {
		int num = min.pop();
		min.push(num);
		return num;
	}
}
