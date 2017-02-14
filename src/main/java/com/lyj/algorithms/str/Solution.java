package com.lyj.algorithms.str;

/**
 * 请实现一个函数，把字符串中的每个空格替换成“%20”
 * @author Ja0ck5
 *
 */
public class Solution {
	
	public static String replaceBlank(String target){
		//1 判断
		if(null == target) return null;
		//2 
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < target.length(); i++) {
			//
			if(' ' == target.charAt(i)){
				sb.append("%20");
			}else{
				sb.append(String.valueOf(target.charAt(i)));
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s="We are family ";
		System.out.println(replaceBlank(s));
	}

}
