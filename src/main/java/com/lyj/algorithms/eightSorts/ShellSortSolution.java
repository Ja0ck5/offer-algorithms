package com.lyj.algorithms.eightSorts;

public class ShellSortSolution {
	public static void shellSort(int[] a) {
		if (null == a || a.length < 2)
			return;
		int h=1,j;
		while(h<a.length/3) h = 3*h+1;//1,4,13,40...
		while(h>=1) {
			// 从1B开始先和1A比较 然后2A与2B...然后再1C向前与同组的比较
			//插入排序,将数组变成 h 有序
			for (int i = h; i < a.length; i++) {
				// 内部直接插入
				int temp = a[i];
				for(j = i-h;j >=0 && temp < a[j];j -= h) 
					a[j+h] = a[j];
				a[j+h] = temp;
			}
			h/=3;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {2,5,4,3,1,7,9,8,6};
		shellSort(array);
		printArray(array);
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(" "+array[i]);
		}
	}
}
