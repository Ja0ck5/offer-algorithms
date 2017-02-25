package com.lyj.algorithms.str;


/**
 * 字符串 abdacbbbbbcccb 中出现次数最多的字符
 * 
 * @author Ja0ck5
 *
 */
public class Solution5 {
	
	public static void findMostChar(String target){
		
		target.charAt(0);
		
		int[] count = new int[target.length()];
		
		for (int i = 0; i < count.length; i++) {
			char tmp = target.charAt(i);
			for (int j = 0; j < count.length; j++)
				if(tmp == target.charAt(j))
					count[i]++;
		}
		
		int idx = 0;
		int max = count[idx];
		for (int i = 0; i < count.length; i++) {
			if(max < count[i]){
				max = count[i];
				idx = i;
			}
		}
		System.out.println(target.charAt(idx));
	}
	
	public static void main(String[] args) {
		findMostChar("abdacbbbbbcccb");
	}
	
}
