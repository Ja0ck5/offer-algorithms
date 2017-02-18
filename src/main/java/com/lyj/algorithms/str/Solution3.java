package com.lyj.algorithms.str;

/**
 * ��ת����˳�� VS ����ת�ַ�����
 * 
 * ����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣 Ϊ������������ź���ͨ��ĸһ���������������ַ����� I am a
 * student.���� ������� student. a am I�� .
 * 
 * @author Ja0ck5
 *
 */
public class Solution3 {

	public static void main(String[] args) {
		Solution3 s3 = new Solution3();
		String string = "I am a student.";
		s3.reverseSentence(string);
	}

	public void reverseSentence(String sentence) {
		if (sentence == null)
			return;
		String[] str = sentence.split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = str.length - 1; i >= 0; i--) {
			sb.append(str[i] + " ");
		}
		System.out.println(sb);
	}

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
	 * ����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ְ���˳�򲻱䡣 Ϊ������������ź���ͨ��ĸһ������
	 *
	 * @param data
	 * @return
	 */
	public static char[] reverseSentence(char[] data) {
		if (data == null || data.length < 1) {
			return data;
		}
		reverse(data, 0, data.length - 1);
		int start = 0;
		int end = 0;
		while (start < data.length) {
			if (data[start] == ' ') {
				start++;
				end++;
			} else if (end == data.length || data[end] == ' ') {
				reverse(data, start, end - 1);
				end++;
				start = end;
			} else {
				end++;
			}
		}
		return data;
	}
}
