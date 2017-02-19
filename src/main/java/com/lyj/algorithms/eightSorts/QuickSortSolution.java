package com.lyj.algorithms.eightSorts;

public class QuickSortSolution {

	public void quickSort(int[] a, int lo, int hi) {
		if (null == a || a.length < 2)
			return;
		if (hi < lo) return;
			//切分后得到基准点
			int mid = partition(a, lo, hi);//快排的切分
			quickSort(a, lo, mid-1);//左半部分排序
			quickSort(a, mid+1, hi);//右半部分排序
	}
	
	//快速排序的切分 切分的位置取决于数组的内容 找到不大于不小于的中数
	private int partition(int[] a, int lo, int hi) {
		//选择基准点
		int pivot = a[lo];

		while (lo < hi) {
			// a[hi] 与基准点比较，如果大于，则 hi 指针往左移动。注意等于，否则死循环
			while (lo < hi && a[hi] >= pivot)
				hi--;
			// a[hi] 小于基准点则  hi与lo交换位置
			a[lo] = a[hi];
			
			//a[lo] 与基准点比较，如果小于等于 则 lo 指针往右移动。 注意等于，否则死循环
			while (lo < hi && a[lo] <= pivot)
				lo++;
			
			// a[lo] 大于基准点则  hi与lo交换位置
			a[hi] = a[lo];
			//最终 a[hi] 要大于基准点，a[lo]要小于基准点
		}
		a[lo] = pivot;//基准点的值赋值给最后的 lo 。排序完毕
		return lo;//返回基准点索引
	}
}
