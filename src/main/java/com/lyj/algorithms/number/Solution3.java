package com.lyj.algorithms.number;

import java.util.Arrays;
import java.util.Stack;

/**
 * ���� min ������ջ ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�min������ �ڸ�ջ�У�����min��
 * push��pop�¶�ʱ�临�Ӷȶ���O(1)
 * 
 * ˼·����һ��ջdata�������ݣ�������һ��ջmin����������ջ��С���� ���磬data��������ջ��5, 4, 3, 6, 7, 8, 2, 1
 * ��min������ջ��5, 4, 3,2, 1 
 * 
 * no����˴β���ջ ÿ����ջ��ʱ�������ջ��Ԫ�ر�min�е�ջ��Ԫ��С���������ջ��������ջ��
 * 
 * @author Ja0ck5
 *
 */
public class Solution3 {
	Stack<Integer> stack = new Stack<>();
	/**
	 * ����
	 */
	Stack<Integer> stackMin = new Stack<>();

	public void push(int node) {
		stack.push(node);
		if (stackMin.isEmpty()) {
			stackMin.push(node);
		} else if (node < min()) {
			stackMin.push(node);
		} else {
			stackMin.push(min());
		}
	}

	public int pop() {
		stackMin.pop();
		return stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int min() {
		return stackMin.peek();
	}
}
