package com.lyj.algorithms.str;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如输入字符串“ abcdefg”和 数字2.该函数左旋转 2 位得到的结果“ cdefgab".
 * 
 * @author Ja0ck5
 *
 */
public class Solution4 {
	
	
	/**
	 * 将data中start到end之间的数字反转
	 *
	 * @param data
	 * @param start
	 * @param end
	 */
	public static void reverse(char[] data, int start, int end) {
		if (data == null || data.length < 1 || start < 0 || end > data.length || start > end)
			return;
		while (start < end) {
			char tmp = data[start];
			data[start] = data[end];
			data[end] = tmp;
			start++;
			end--;
		}
	}
	
	/**
	 * 题目二：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
	 * 请定义一个函数实现字符串左旋转操作的功能。
	 * @param data
	 * @param n
	 * @return
	 */
	public static char[] leftRotateString(char[] data, int n) {
	    if (data == null || n < 0 || n > data.length)
	        return data;
	    //整体旋转
	    reverse(data, 0, data.length - 1);
	    //开头到指定位置旋转
	    reverse(data, 0, data.length - n - 1);
	    //指定位置到结尾旋转
	    reverse(data, data.length - n, data.length - 1);
	    return data;
	}
	
	public static void main(String[] args) {
		char[] data = "abcdefg".toCharArray();
		System.out.println(Solution4.leftRotateString(data , 2));
	}

}
