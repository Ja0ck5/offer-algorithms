package com.lyj.algorithms.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 从上往下打印二叉树
 * 
 * 1，从上往下打印二叉树的每个结点
 * 2，同一层的结点按照从左到右的顺序打印。
 * @author Ja0ck5
 *
 */
public class Solution3 {
	
	public static class BinaryTreeNode{
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;
		public BinaryTreeNode() {}
		public BinaryTreeNode(int val) {
			this.val = val;
		}
		@Override
		public String toString() {
			return "BinaryTreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
	}
	
	public static void printBinaryTreeNode(BinaryTreeNode root){
		if(null == root)
			return;
		Queue<BinaryTreeNode> q = new LinkedBlockingQueue<BinaryTreeNode>();
		q.add(root);
		while(!q.isEmpty()){
			BinaryTreeNode n = q.poll();
			System.out.println(n.val);
			if(n.left != null)
				q.add(n.left);
			if(n.right!= null)
				q.add(n.right);
		}
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
		printBinaryTreeNode(root);
	}
}
