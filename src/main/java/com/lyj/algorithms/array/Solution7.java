package com.lyj.algorithms.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 把数组排成最小的数
 * 
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼 接出的所有数字的最小的一个。例如输入{3,32,321}，则打印最小的数字是
 * 321323.
 * 
 * @author Ja0ck5
 *
 */
public class Solution7 {

	public static void main(String[] args) {
		Solution7 test = new Solution7();
		int[] array = { 3, 32, 321 };
		test.printMin(array);
		test.printMinNo(array);
	}

	public void printMin(int[] array) {
		int[] clone = array.clone();
		printMinNumber(clone, 0, clone.length - 1);
		for (int i : clone)
			System.out.print(i);
	}

	private void printMinNumber(int[] array, int start, int end) {
		if (start < end) {
			int main_number = array[end];
			int small_cur = start;
			for (int j = start; j < end; j++) {
				if (isSmall(String.valueOf(array[j]), String.valueOf(main_number))) {
					int temp = array[j];
					array[j] = array[small_cur];
					array[small_cur] = temp;
					small_cur++;
				}
			}
			array[end] = array[small_cur];
			array[small_cur] = main_number;
			printMinNumber(array, 0, small_cur - 1);
			printMinNumber(array, small_cur + 1, end);
		}
	}

	private boolean isSmall(String m, String n) {
		String left = m + n;
		String right = n + m;
		boolean result = false;
		for (int i = 0; i < left.length(); i++) {
			if (left.charAt(i) < right.charAt(i))
				return true;
			else if (left.charAt(i) > right.charAt(i))
				return false;
		}
		return result;
	}

	public void printMinNo(int[] numbers) {
		int n;
		String s = "";
		List<Integer> list = new ArrayList<Integer>();
		n = numbers.length;
		for (int i = 0; i < n; i++)
			list.add(numbers[i]);

		Collections.sort(list, new Comparator<Integer>() {

			public int compare(Integer str1, Integer str2) {
				String s1 = str1 + "" + str2;
				String s2 = str2 + "" + str1;
				return s1.compareTo(s2);
			}
		});

		for (int j : list)
			s += j;
		System.out.println(s);
	}
}
