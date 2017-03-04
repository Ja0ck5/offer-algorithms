package com.lyj.algorithms.array;

/**
 * 一个二维数组，每一行从左到右递增，每一列从上到下递增
 * 
 * 输入一个二维数组和一个整数，判断数组中是否含有该整数
 * 
 * @author Ja0ck5
 *
 */
public class Solution {
	public static boolean find2Dimesion(int[][] array, int number) {
		if (null == array || 0 == array.length)// 1 合理判断
			return false;
		int i = array.length - 1;//2 行数
		int j = 0;//3 列数
		while ((i >= 0) && (j < array[0].length)) {
			if (number == array[i][j])
				return true;
			else if (number < array[i][j])//4 大于目标 number 则 行 减小
				i--;
			else//5 小于目标数列增加
				j++;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] a=new int[4][4];
		a[0][0]=1;
		a[0][1]=2;
		a[0][2]=8;
		a[0][3]=9;
		a[1][0]=2;
		a[1][1]=4;
		a[1][2]=9;
		a[1][3]=12;
		a[2][0]=4;
		a[2][1]=7;
		a[2][2]=10;
		a[2][3]=13;
		a[3][0]=6;
		a[3][1]=8;
		a[3][2]=11;
		a[3][3]=15;
		System.out.println(find2Dimesion(a, 1));
	}
}
