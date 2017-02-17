package com.lyj.algorithms.number;

/**
 * 丑数
 * 
 * 我们把只包含因子 2,3,和 5 的称为丑数。
 * 
 * 丑数具有如下特征：1是丑数，丑数可以表示为有限个2、3、5的乘积
 * 
 * 求按从小到大的顺序的第 1500 个丑数。例如 6、 8 都是丑数， 但 14不是，因为它包含因子 7.习惯上我们把 1 当做第一个丑数。
 * 
 * @author Ja0ck5
 *
 */
public class Solution5 {

	public int getUglyNumber(int n) {
		if (n < 0)
			return 0;
		int[] uglyArray = new int[n];
		uglyArray[0] = 1;
		int ft2 = 1;
		int ft3 = 1;
		int ft5 = 1;
		for (int i = 1; i < uglyArray.length; i++) {
			int min = min(ft2 * 2, ft3 * 3, ft5 * 5);
			uglyArray[i] = min;
			while (ft2 * 2 <= min)
				ft2++;
			while (ft3 * 3 <= min)
				ft3++;
			while (ft5 * 5 <= min)
				ft5++;
		}
		return uglyArray[n - 1];
	}

	private int min(int i, int j, int k) {
		int min = (i < j) ? i : j;
		return (min < k) ? min : k;
	}

}
