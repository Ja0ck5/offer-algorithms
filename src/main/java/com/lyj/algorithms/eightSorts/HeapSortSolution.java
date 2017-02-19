package com.lyj.algorithms.eightSorts;

/**
 * 如果它有左子树，那么
 * 左子树的位置是2i+1，
 * 
 * 如果有右子树，
 * 右子树的位置是2i+2，
 * 
 * 如果有父节点，
 * 父节点的位置是(n-1)/2取整
 * 
 * @author Ja0ck5
 *
 */
public class HeapSortSolution {
	public void heapSort(int[] a) {
		if (null == a || a.length < 2)
			return;
		// 建堆
		buildMaxHeap(a);
	
		for (int i = a.length - 1; i >= 0; i--) {
//			将每个当前最大的值放到堆末尾
			int temp = a[0];// 将堆顶元素和堆低元素交换，即得到当前最大元素正确的排序位置
			a[0] = a[i];
			a[i] = temp;
			// 调整堆
			adjustHeap(a, i, 0);
		}
	}

	// 构建大顶堆：将array看成完全二叉树的顺序存储结构
	private void buildMaxHeap(int[] a) {
		//父节点的位置是(n-1)/2取整
		// 从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
		for (int i = (a.length / 2)-1; i >= 0; i--)
			adjustHeap(a, a.length, i);
	}

	// 递归调整堆
	private void adjustHeap(int[] a, int size, int parent) {
		//左子树的位置是2i+1
		int left = 2 * parent + 1;
		//右子树的位置是2i+2
		int right = 2 * parent + 2;
		
		int largest = parent;
		if (left < size && a[left] > a[parent])
			largest = left;

		if (right < size && a[right] > a[largest])
			largest = right;

		if (parent != largest) {
			int temp = a[parent];
			a[parent] = a[largest];
			a[largest] = temp;
			adjustHeap(a, size, largest);
		}
	}
}
