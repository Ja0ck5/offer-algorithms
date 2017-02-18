package com.lyj.algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为 s 的两个数字 VS 和为 s 的连续正数序列
 * 
 * 输一个递增排序的数组和一个数字 s,在数组中查找两个数使得它们的 和正好是 s。如果有多对数字的和等于 s，输出任意一对即可。例如：输入数组
 * {1,2,4,7,11,15}和数字为 15.输出 4 和 11.
 * 
 * @author Ja0ck5
 *
 */
public class Solution11 {
	public static List<Integer> findNumbersWithSum(int[] data, int sum) {
		List<Integer> result = new ArrayList<>(2);
		if (data == null || data.length < 2) {
			return result;
		}
		int ahead = data.length - 1;
		int behind = 0;
		long curSum; // 统计和，取long是防止结果溢出
		//左右逼近
		while (behind < ahead) {
			curSum = data[behind] + data[ahead];
			if (curSum == sum) {
				result.add(data[behind]);
				result.add(data[ahead]);
				break;
			} else if (curSum < sum) {
				behind++;
			} else {
				ahead--;
			}
		}
		return result;
	}
}
