package com.lyj.algorithms.eightSorts;

public class InsertSortSolution {
	
	public static void insertionSort(int[] a) {
		if (null == a || a.length < 2)
			return;
		int j;
		//循环从第二个数组元素开始，因为arr[0]作为最初已排序部分
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];// 暂存当前值
			for (j = i - 1;j >= 0 && temp < a[j];j--)//将temp与已排序元素从大到小比较，寻找temp应插入的位置
				a[j + 1] = a[j];//比temp大则后移
			a[j + 1] = temp;// 当前值归位
		}
	}

	
	public static void main(String[] args) {
		int[] array = {2,5,4,3,1,7,9,8,6};
		insertionSort(array);
		printArray(array);
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(" "+array[i]);
		}
	}
}
