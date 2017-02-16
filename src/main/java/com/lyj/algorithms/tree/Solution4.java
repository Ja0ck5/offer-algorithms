package com.lyj.algorithms.tree;

/**
 * 二叉搜索树的后序遍历序列
 * 
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。 是则返回true，否则返回false。
 * 
 * 二叉搜索树特点：对任意一个结点，其值大于左子树所有结点的值，小于右子树所有结点的值
 * 
 * @author Ja0ck5
 *
 */
public class Solution4 {

	class BinaryNode {
		int val;
		BinaryNode left;
		BinaryNode right;

		public BinaryNode() {
		}

		public BinaryNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "BinaryNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
	}

	public static boolean isBackSequenceTree(int[] sequence) {
		if (sequence.length == 0)
			return false;
		if (sequence.length == 1)
			return true;
		return judge(sequence, 0, sequence.length - 1);

	}

	public static boolean judge(int[] a, int l, int r) {
		if (l >= r)
			return true;
		int i = r;
		// 从后面开始找
		while (i > l && a[i - 1] > a[r])
			i--;// 找到比根小的坐标
		// 从前面开始找 l 到i-1应该比根小
		for (int j = l; j < i - 1; j++)
			//左节点比根节点大，则 false
			if (a[j] > a[r])
				return false;
		//再判断左右子树是否符合 后序遍历 的 二叉搜索树
		return judge(a, l, i - 1) && judge(a, i, r - 1);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 5, 7, 6, 9, 11, 10, 8 };
		int[] b = new int[] { 7, 4, 6, 5 };
		int[] c = new int[] { 11, 10, 9, 8 };
		System.out.println(isBackSequenceTree(a));
//		System.out.println(isBackSequenceTree(b));
//		System.out.println(isBackSequenceTree(c));
	}

}
