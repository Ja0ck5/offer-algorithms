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

	class BinaryNode{
		int val;
		BinaryNode left;
		BinaryNode right;
		public BinaryNode() {}
		public BinaryNode(int val) {
			this.val = val;
		}
		@Override
		public String toString() {
			return "BinaryNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
	}
	
	public static boolean isBackSequenceTree(int[] seq){
		
		return false;
	}
	
}
