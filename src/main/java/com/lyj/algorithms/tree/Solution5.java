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

	private List<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
	private List<Integer> list = new ArrayList<Integer>();

	public  List<ArrayList<Integer>> findPath(BinaryTreeNode root, int target) {
		if (root == null)
			return listAll;
		list.add(root.val);
		//目标值减去经过的值
		target -= root.val;
		if (target == 0 && root.left == null && root.right == null)
			listAll.add(new ArrayList<Integer>(list));
		//查询左节点
		findPath(root.left, target);
		//查询右节点
		findPath(root.right, target);
		//移除最后一个元素,深度遍历完一条路径后要回退
		list.remove(list.size() - 1);
		return listAll;
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);

		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);

		Solution5 s5 = new Solution5();
		System.out.println(s5.findPath(root,7));
	}

}
