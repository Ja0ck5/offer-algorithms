package com.lyj.algorithms.tree;


/**
 * 输入一棵二叉树的根结点，判断该树是不是平衡二叉树。
 * 
 * 如果某二叉树 中任意结点的左右子树的深度相差不超过1，那么他就是一棵平衡二叉树。
 * 
 * @author Ja0ck5
 *
 */
public class Solution7 {
	public boolean isBalanced(BinaryTreeNode root) {
		int depth = 0;
		return isBalanced(root, depth);
	}

	private boolean isBalanced(BinaryTreeNode root, int depth) {
		if (root == null) {
			depth = 0;
			return true;
		}
		int left = 0, right = 0;
		if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
			int diff = left - right;
			if (diff <= 1 && diff >= -1) {
				depth = 1 + (left > right ? left : right);
				return true;
			}
		}
		return false;
	}

	public static class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		public BinaryTreeNode() {
		}

		public BinaryTreeNode(int val) {
			this.val = val;
		}

	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode node1 = new BinaryTreeNode(2);
		BinaryTreeNode node2 = new BinaryTreeNode(3);
		BinaryTreeNode node3 = new BinaryTreeNode(4);
		BinaryTreeNode node4 = new BinaryTreeNode(5);
		BinaryTreeNode node5 = new BinaryTreeNode(6);
		BinaryTreeNode node6 = new BinaryTreeNode(7);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.right = node5;
		node4.left = node6;
		Solution7 s7 = new Solution7();
		System.out.println(s7.isBalanced(root));
	}
}
