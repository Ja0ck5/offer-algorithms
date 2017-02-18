package com.lyj.algorithms.str;

/**
 * �ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β����
 * �붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ�
 * ���������ַ����� abcdefg���� ����2.�ú�������ת 2 λ�õ��Ľ���� cdefgab".
 * 
 * @author Ja0ck5
 *
 */
public class Solution4 {
	
	
	/**
	 * ��data��start��end֮������ַ�ת
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
	 * ��Ŀ�����ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β����
	 * �붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ�
	 * @param data
	 * @param n
	 * @return
	 */
	public static char[] leftRotateString(char[] data, int n) {
	    if (data == null || n < 0 || n > data.length)
	        return data;
	    //������ת
	    reverse(data, 0, data.length - 1);
	    //��ͷ��ָ��λ����ת
	    reverse(data, 0, data.length - n - 1);
	    //ָ��λ�õ���β��ת
	    reverse(data, data.length - n, data.length - 1);
	    return data;
	}
	
	public static void main(String[] args) {
		char[] data = "abcdefg".toCharArray();
		System.out.println(Solution4.leftRotateString(data , 2));
	}

}
