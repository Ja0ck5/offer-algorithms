package com.lyj.algorithms.tree;


/**
 * 树的子结构
 * 输入两颗二叉树 A 和 B，判断 B 是不是 A 的子结构
 * @author Ja0ck5
 *
 */
public class Solution1 {
	public static class BinaryTreeNode {
		// 节点值
		 int val;
		// 左节点
		BinaryTreeNode left;
		// 右节点
		BinaryTreeNode right;

		public BinaryTreeNode() {}

		public BinaryTreeNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "BinaryTreeNode [val=" + val + " left=" + left + ", right=" + right + "]";
		}
	    
	}
	public static boolean hasSubTree(BinaryTreeNode btn1,BinaryTreeNode btn2){
		
		return false;
	}

}
