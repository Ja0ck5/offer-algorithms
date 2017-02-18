package com.lyj.algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正数 s，打印出所有和为 s 的连续正数序列（至少含两个数）。
 * 
 * 例如输入 15，由于 1+2+3+4+5=4+5+6=7+8=15，所以结果打印出
 * 
 * 3个连续序列 1-5、 4-6、和 7-8.
 * 
 * @author Ja0ck5
 *
 *
 *         考虑用两个数 small 和 big 分别表示序列的最小值和最大值。首先把 small 初始化为 1，big 初始化为 2。如果从
 *         small 到 big 的序列的和大于 s，我们可以从序列中去掉较小的值，也就是增大 small 的值。如果从 small 到 big
 *         的序列的和小于 s，我们可以增大 big，让这个序列包含更多的数字。因为这个序列至少要有两个数字，我们一直增加 small
 *         到(1+s)/2 为止。
 * 
 *         以求和为 9 的所有连续序列为例，我们先把 small 初始化为 1，big 初始化为 2。此时介于 small 和 big
 *         之间的序列是｛1，2}，序列的和为 3，小于 9，所以我们下一步要让序列包含更多的数字。
 *         我们把 big 增加 1 变成 3，此时序列为｛1,2,3}。由于序列的和是 6，仍然小于 9，
 *         我们接下来再增加 big 变成 4，介于 small 和 big 之间的序列也随之变成｛1, 2, 3, 4｝。
 *         由于列的和 10 大于 9，我们要删去去序列中的一些数字， 于是我们增加 small 变成2，此时得到的序列是｛2, 3, 4｝，序列的和E好是 9。
 *         我们找到了第一个和为 9 的连续序列，把它打印出来。接下来我们再增加big，重复前面的过程，可以找到第二个和为 9 的连续序列｛4，5}。
 */
public class Solution12 {
	public static List<List<Integer>> findContinuousSequence(int sum) {
		List<List<Integer>> result = new ArrayList<>();
		if (sum < 3) 
			return result;
		int small = 1;
		int big = 2;
		int mid = (1 + sum) / 2;
		int curSum = small + big;
		while (small < mid) {
			if (curSum == sum) {
				List<Integer> list = new ArrayList<>(2);
				for (int i = small; i <= big; i++) {
					list.add(i);
				}
				result.add(list);
			}
			while (curSum > sum && small < mid) {
				curSum -= small;
				small++;
				if (curSum == sum) {
					List<Integer> list = new ArrayList<>(2);
					for (int i = small; i <= big; i++) {
						list.add(i);
					}
					result.add(list);
				}
			}
			big++;
			curSum += big;
		}
		return result;
	}
}
