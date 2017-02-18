package com.lyj.algorithms.number;

/**
 * 不用加减乘除做加法
 * 
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、 -、 *、 /四则 运算符号。
 * 
 * @author Ja0ck5
 *
 */
public class Solution8 {
	public static void main(String[] args) {
		Solution8 s8 = new Solution8();
		System.out.println(s8.add(8, 16));
	}

	public int add(int x, int y) {
		int sum, carry;
		do {
			/**
			 * 第一步不考虑进位对每一位相加。0 加 0 、1 加 1 的结果都 0。 0 加 1 、1 加 0 的结果都是 1
			 * 这和异或的结果是一样的
			 */
			sum = x ^ y;
			/**
			 * 第二步考虑进位，对加 0 、0 加 1 、1 加 0 而言， 都不会产生进位，只有 1 加 1
			 * 时，会向前产生一个进位。此时我们可以想象成是两个数先做位与运算，然后再向左移动一位。只有两个数都是 1 的时候，位与得到的结果是
			 * 1，其余都是 0
			 */
			carry = (x & y) << 1;
			/**
			 * 第三步把前两个步骤的结果相加。第三步相加的过程依然是重复前面两步， 直到不产生进位为止
			 */
			x = sum;
			y = carry;
		} while (y != 0);
		return x;
	}
}
