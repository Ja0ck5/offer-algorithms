package com.lyj.algorithms.number;

/**
 * 实现函数 double Power （ double base， int exponent） 求 base 的 exponent
 * 次方。不得使用库函数，同时不需要考虑大数问题
 * 
 * @author Ja0ck5
 *
 */
public class Solution1 {

	public double power(double base, int exponent) throws Exception {
		double result = 0.0;
		if (equal(base, 0.0) && exponent < 0) {
			throw new Exception("0的负数次幂没有意义");
		}
		if (exponent < 0) {
			result = 1.0 / powerWithExpoment(base, -exponent);
		} else {
			result = powerWithExpoment(base, exponent);
		}
		
		return result;
	}

	private double powerWithExpoment(double base, int exponent) {
		if (exponent == 0) 
			return 1;
		if (exponent == 1) 
			return base;
		
		double result = 1.0;
		for (int i = 1; i <= exponent; i++) 
			result *=  base;
		return result;
	}

	/**
	 * double 类型的比较
	 * 两个数相减绝对值属于某个范围
	 * @param num1
	 * @param num2
	 * @return
	 */
	private boolean equal(double num1, double num2) {
		boolean flag = false;
		if ((num1 - num2 > -0.0000001) && num1 - num2 < 0.0000001) 
			flag = true;
		return flag;
	}
	
	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		try {
			System.out.println(solution1.power(3.0, 3));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
