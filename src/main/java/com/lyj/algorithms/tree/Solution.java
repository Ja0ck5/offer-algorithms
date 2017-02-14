package com.lyj.algorithms.tree;

import java.util.Arrays;

/**
 * 输入二叉树的前序遍历和中序遍历的结果，重建出该二叉树。 假设前序遍历和中序遍历结果中都不包含重复的数字， 例如输入的前序遍历序列
 * {1,2,4,7,3,5,6,8}和 中序遍历序列{4,7,2,1,5,3,8,6}重建出如图所示的二叉树
 * 
 * --- | 1 | --- / \ / \ --- --- | 2 | | 3 | --- --- / / \ / / \ --- --- --- | 4
 * | | 5 | | 6 | --- --- --- \ / \ / --- --- | 7 | | 8 | --- ---
 * 
 * @author Ja0ck5
 *
 */
public class Solution {

	public static class BinaryTreeNode {
		// 节点值
		 int val;
		// 左节点
		BinaryTreeNode left;
		// 右节点
		BinaryTreeNode right;

		public BinaryTreeNode() {
			super();
		}

		public BinaryTreeNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "BinaryTreeNode [val=" + val + " left=" + left + ", right=" + right + "]";
		}
	    
	}

	/*public static BinaryTreeNode reConstructTree(int[] preSeq, int[] midSeq) {

		if (null == preSeq || null == midSeq)
			return null;
		if (preSeq.length != midSeq.length)
			throw new RuntimeException("length unconsistent");
		// 1 根节点
		BinaryTreeNode root = new BinaryTreeNode();
		for (int i = 0; i < midSeq.length; i++) {
			if (preSeq[0] == midSeq[i]) {
				// 得到根节点的值
				root.val = midSeq[i];
				System.out.println("root value is : " + root.val);

				// 左节点
				root.left = reConstructTree(Arrays.copyOfRange(preSeq, 1, i + 1), Arrays.copyOfRange(midSeq, 0, i));
				// 左节点
				root.right = reConstructTree(Arrays.copyOfRange(preSeq, i + 1, preSeq.length),
						Arrays.copyOfRange(midSeq, i + 1, midSeq.length));
			}
		}

		return root;
	}*/

	private static BinaryTreeNode recusiveConstruct(int[] p, int pStart, int pEnd, int[] m, int mStart, int mEnd) {
		
		BinaryTreeNode root = new BinaryTreeNode(p[pStart]);
		if (pStart == pEnd) return root;
		//分隔点
		int partition = 0;
		for (int i = mStart; i <= mEnd; i++) {
			if (m[i] == p[pStart]) {
				partition = i;
				break;
			}
		}
		//每棵子树 也看成一棵树
		//left
		if (partition - mStart > 0)  // p {1,#2,4,7#,3,5,6,8}       m {#4,7,2#,1,5,3,8,6}
			root.left = recusiveConstruct(p, pStart + 1, pStart + partition - mStart, m, mStart, partition - 1);
		// right
		if (mEnd - partition > 0)// p {1,2,4,7,#3,5,6,8#}       m {4,7,2,1,#5,3,8,6#}
			root.right = recusiveConstruct(p, pStart + partition - mStart + 1, pEnd, m, partition + 1, mEnd);
		return root;
	}

	public static void main(String[] args) {
		int[] preSeq = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] midSeq = { 4, 7, 2, 1, 5, 3, 8, 6 };
		BinaryTreeNode root = recusiveConstruct(preSeq,0,preSeq.length-1,midSeq,0,midSeq.length-1);
		System.out.println(root);
	}
	
}
