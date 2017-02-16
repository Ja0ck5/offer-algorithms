package com.lyj.algorithms.array;

/**
 * �����г��ִ�������һ�������
 * 
 * ��������һ�����ֳ��ִ����������鳤�ȵ�һ�룬���ҳ�������֡� ���� ����һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * 2���ֵĴ����������鳤�ȵ� һ�룬������2.
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

		// ���ִ���
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
