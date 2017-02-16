package com.lyj.algorithms.stack;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * 
 * 实际是判断是否为栈的合法输出序列
 * 
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是 否为该栈的弹出序列。假设压入栈的所有数字均不相等。
 * 
 * 例如压栈序列为 1、 2、 3、 4、5.序列 4、 5、 3、 2、 1 是压栈序列对应的一个弹出序列，但 4、 3、 5、 1、 2 却不是。
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
	 * 推荐
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isPopOrder2(int[] s1, int[] s2) {
		if (s1.length == 0 || s2.length == 0)
			return false;
		Stack<Integer> s = new Stack<Integer>();
		// 用于标识弹出序列的位置
		int mark = 0;
		for (int i = 0; i < s1.length; i++) {
			s.push(s1[i]);
			// 如果栈不为空，且栈顶元素等于弹出序列
			while (!s.empty() && s.peek() == s2[mark]) {
				// 出栈
				s.pop();
				// 弹出序列向后移一位
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
			//将 s1 入栈序列 顺序入栈
			s.push(s1[i]);
			while(!s.empty() && s.peek() == s2[mark]){
				//出栈
				s.pop();
				//标记往后移动一位
				mark++;
			}
		}
		return s.empty();
	}
}
