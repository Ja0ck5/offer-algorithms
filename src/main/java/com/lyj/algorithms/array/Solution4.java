package com.lyj.algorithms.array;

/**
 * 数组中出现次数超过一半的数组
 * 
 * 数组中有一个数字出现次数超过数组长度的一半，请找出这个数字。 例如 输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 2出现的次数超过数组长度的 一半，因此输出2.
 * 
 * @author Ja0ck5
 *
 */
public class Solution4 {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		Solution4 p = new Solution4();
		System.out.println(p.moreThanHalf(array));
	}

	public Integer moreThanHalf(int[] array) {
		if (null == array)
			return null;

		Integer rst = null;
		Integer cnt = 0;
		for (int i = 0; i < array.length; i++) {
			if (0 == cnt) {
				rst = array[i];
				cnt = 1;
			} else if (array[i] == rst) {
				cnt++;
			} else
				cnt--;
		}

		// 出现次数
		int times = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == rst)
				times++;
		}
		if (times * 2 <= array.length)
			return null;
		else
			return rst;
	}
}
