package com.lyj.algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * ��Ϊ s ���������� VS ��Ϊ s ��������������
 * 
 * ��һ����������������һ������ s,�������в���������ʹ�����ǵ� �������� s������ж�����ֵĺ͵��� s���������һ�Լ��ɡ����磺��������
 * {1,2,4,7,11,15}������Ϊ 15.��� 4 �� 11.
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
		long curSum; // ͳ�ƺͣ�ȡlong�Ƿ�ֹ������
		//���ұƽ�
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
