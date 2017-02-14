package com.lyj.algorithms.number;

/**
 * 输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如把 9 表示成二进制是 1001；有 2 位是 1，因此如果输入 9，函数输出 2.
 * 
 * 
 * 减1的结果是把最右边的一个1开始的所有位都取反了。
 * 
 * 这个时候如果我们再把原来的整数和减去1之后的结果做与运算，
 * 
 * 从原来整数最右边一个1那一位开始所有位都会变成0。如1100&1011=1000.
 * 
 * 
 * 
 * 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.
 * 
 * 
 * 
 * 一个整数的二进制有多少个1，就可以进行多少次这样的操作
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
