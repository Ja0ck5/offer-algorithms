package com.lyj.algorithms.treeAndList;

import java.util.Stack;

/**
 * ������������˫������
 * 
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * 
 * Ҫ�� ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
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
		BinaryTreeNode pre = null;// ���ڱ�������������е���һ�ڵ�
		boolean isFirst = true;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			p = stack.pop();
			if (isFirst) {
				root = p;// ��������������еĵ�һ���ڵ��Ϊroot
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
