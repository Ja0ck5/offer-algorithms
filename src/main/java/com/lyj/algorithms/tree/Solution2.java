package com.lyj.algorithms.tree;

import java.util.Stack;

/**
 * 二叉树的镜像 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 
 * @author Ja0ck5
 *
 */
public class Solution2 {

	// 构建树
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
			return "BinaryTreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}

	}

	/**
	 * recursiveMirrorTree
	 * 递归
	 * @param root
	 * @return
	 */
	public static BinaryTreeNode recursiveMirrorTree(BinaryTreeNode root) {
		if (null == root)
			return null;
		// 交换节点的左右子节点
		BinaryTreeNode tmpNode = root.left;
		root.left = root.right;
		root.right = tmpNode;
		// 递归。左右子节点
		recursiveMirrorTree(root.left);
		recursiveMirrorTree(root.right);

		return root;
	}

	/**
	 * non-recursiveMirrorTree
	 * 非递归
	 * @param root
	 * @return
	 */
	public static BinaryTreeNode nonRecursiveMirrorTree(BinaryTreeNode root) {
		if (null == root)
			return null;

		BinaryTreeNode tmpNode = null;
		BinaryTreeNode cur = null;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		//根节点入栈
		stack.push(root);
		while (!stack.isEmpty()) {
			cur = stack.pop();
			// 交换节点的左右子节点
			tmpNode = cur.left;
			cur.left = cur.right;
			cur.right = tmpNode;

			// 重新入栈
			if (cur.left != null)
				stack.push(cur.left);
			if (cur.right != null)
				stack.push(cur.right);
		}

		return root;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);

		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);

		System.out.println(root);
		System.out.println(recursiveMirrorTree(root));
		System.out.println(nonRecursiveMirrorTree(root));
	}

}
