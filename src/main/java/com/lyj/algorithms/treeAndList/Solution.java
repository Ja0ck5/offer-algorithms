package com.lyj.algorithms.treeAndList;

import java.util.Stack;

/**
 * 二叉搜索树与双向链表
 * 
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 
 * 要求 不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * @author Ja0ck5
 *
 */
public class Solution {
	public static class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		public BinaryTreeNode() {
		}

		public BinaryTreeNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "BinaryNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
	}
	
	// non-recursive
	public BinaryTreeNode nonRecursiveConvert(BinaryTreeNode root) {
		if (root == null)
			return null;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode p = root;
		BinaryTreeNode pre = null;// 用于保存中序遍历序列的上一节点
		boolean isFirst = true;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			p = stack.pop();
			if (isFirst) {
				root = p;// 将中序遍历序列中的第一个节点记为root
				pre = root;
				isFirst = false;
			} else {
				pre.right = p;
				p.left = pre;
				pre = p;
			}
			p = p.right;
		}
		return root;
	}

	
	// recursive
	public BinaryTreeNode convert(BinaryTreeNode root) {
		BinaryTreeNode lastNodeList = null;
		convertNode(root, lastNodeList);
		while (lastNodeList != null && lastNodeList.left != null) {
			lastNodeList = lastNodeList.left;
		}
		return lastNodeList;
	}

	private void convertNode(BinaryTreeNode root, BinaryTreeNode lastNodeList) {
		if (root == null)
			return;
		BinaryTreeNode cur = root;
		if (cur.left != null) {
			convertNode(cur.left, lastNodeList);
		}
		cur.left = lastNodeList;
		if (lastNodeList != null)
			lastNodeList.right = cur;
		lastNodeList = cur;
		if (cur.right != null) {
			convertNode(cur.right, lastNodeList);
		}
	}
}
