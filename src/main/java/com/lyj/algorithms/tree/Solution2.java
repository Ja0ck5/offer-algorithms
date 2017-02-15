package com.lyj.algorithms.tree;

import java.util.Stack;

/**
 * �������ľ��� �����һ������������һ�����������ú���������ľ���
 * 
 * @author Ja0ck5
 *
 */
public class Solution2 {

	// ������
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
	 * �ݹ�
	 * @param root
	 * @return
	 */
	public static BinaryTreeNode recursiveMirrorTree(BinaryTreeNode root) {
		if (null == root)
			return null;
		// �����ڵ�������ӽڵ�
		BinaryTreeNode tmpNode = root.left;
		root.left = root.right;
		root.right = tmpNode;
		// �ݹ顣�����ӽڵ�
		recursiveMirrorTree(root.left);
		recursiveMirrorTree(root.right);

		return root;
	}

	/**
	 * non-recursiveMirrorTree
	 * �ǵݹ�
	 * @param root
	 * @return
	 */
	public static BinaryTreeNode nonRecursiveMirrorTree(BinaryTreeNode root) {
		if (null == root)
			return null;

		BinaryTreeNode tmpNode = null;
		BinaryTreeNode cur = null;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		//���ڵ���ջ
		stack.push(root);
		while (!stack.isEmpty()) {
			cur = stack.pop();
			// �����ڵ�������ӽڵ�
			tmpNode = cur.left;
			cur.left = cur.right;
			cur.right = tmpNode;

			// ������ջ
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
