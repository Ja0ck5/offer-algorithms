package com.lyj.algorithms.array.test;

public class Solution {
	
	public static boolean isInternal(int[][] a ,int n){
		//行数
		int i = a.length-1;
		//列数
		int j = 0;
		
		while((i >=0) && j<a[0].length){
			if(n == a[i][j])
				return true;
			else if(n < a[i][j])
				i--;
			else
				j++;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] a = {{1,2,8,9},
					 {2,4,9,12},
					 {4,7,10,13},
					 {8,11,12,14}};
		
		System.out.println(isInternal(a, 18));//false
		System.out.println(isInternal(a, 14));//ture
	}
	

}
