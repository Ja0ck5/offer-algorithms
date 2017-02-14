package com.lyj.algorithms.number;

/**
 * ʵ�ֺ��� double Power �� double base�� int exponent�� �� base �� exponent
 * �η�������ʹ�ÿ⺯����ͬʱ����Ҫ���Ǵ�������
 * 
 * @author Ja0ck5
 *
 */
public class Solution1 {

	public double power(double base, int exponent) throws Exception {
		double result = 0.0;
		if (equal(base, 0.0) && exponent < 0) {
			throw new Exception("0�ĸ�������û������");
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
	 * double ���͵ıȽ�
	 * �������������ֵ����ĳ����Χ
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
