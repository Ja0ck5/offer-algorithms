package com.lyj.algorithms.treeFor;

import java.util.Stack;

public class PreOrderSolution {

	private static class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		public BinaryTreeNode(int val) {
			this.val = val;
		}
	}

	public static void preOrder(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode node = root;

		while (node != null || stack.size() > 0) {
			while (node != null) {
				visted(node);
				stack.push(node);
				node = node.left;
			}
			while (!stack.isEmpty()) {
				node = stack.pop();
				node = node.right;
			}
		}
	}

	public static void visted(BinaryTreeNode subTree) {
		System.out.println("val : " + subTree.val);
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);

		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);

		preOrder(root);

	}

}
