package com.lyj.algorithms.str;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ��һ��ֻ����һ�ε��ַ�
 * 
 * ���ַ������ҳ���һ��ֻ����һ�ε��ַ���������롰 abaccdeff������ ����� b����
 * 
 * @author Ja0ck5
 *
 */
public class Solution1 {
	public static void main(String[] args) {
		Solution1 p = new Solution1();
		System.out.println(p.firstNotRepeatChar("agbaccdeff"));
	}

	public Character firstNotRepeatChar(String str) {
		if (str == null)
			return null;
		char[] strChar = str.toCharArray();
		Map<Character, Integer> hash = new LinkedHashMap<Character, Integer>();
		for (char item : strChar) {
			if (hash.containsKey(item))
				hash.put(item, hash.get(item) + 1);
			else
				hash.put(item, 1);
		}
		for (char key : hash.keySet()) {
			if (hash.get(key) == 1)
				return key;
		}
		return null;
	}
}
