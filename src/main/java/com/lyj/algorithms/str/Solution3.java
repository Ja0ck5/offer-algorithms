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
}
