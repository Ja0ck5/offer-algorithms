package com.lyj.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所
 * 有路径。从树的根节点开始往下一直到叶结点所经过的结点形成一条路径。
 * 
 * @author Ja0ck5
 *
 */
public class Solution5 {
	
	class BinaryTreeNode {
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

	private List<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
	private List<Integer> list = new ArrayList<Integer>();

	public List<ArrayList<Integer>> FindPath(BinaryTreeNode root, int target) {
		
		if (root == null)
			return listAll;
		list.add(root.val);
		target -= root.val;
		if (target == 0 && root.left == null && root.right == null)
			listAll.add(new ArrayList<Integer>(list));
		FindPath(root.left, target);
		FindPath(root.right, target);
		list.remove(list.size() - 1);
		return listAll;
	}

}
