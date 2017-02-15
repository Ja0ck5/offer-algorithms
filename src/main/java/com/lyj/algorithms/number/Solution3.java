package com.lyj.algorithms.number;

import java.util.Arrays;
import java.util.Stack;

/**
 * 包含 min 函数的栈 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。 在该栈中，调用min、
 * push及pop德尔时间复杂度都是O(1)
 * 
 * 思路：用一个栈data保存数据，用另外一个栈min保存依次入栈最小的数 比如，data中依次入栈，5, 4, 3, 8, 10, 11, 12, 1
 * 则min依次入栈，5, 4, 3，no,no, no, no, 1
 * 
 * no代表此次不如栈 每次入栈的时候，如果入栈的元素比min中的栈顶元素小或等于则入栈，否则不如栈。
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
