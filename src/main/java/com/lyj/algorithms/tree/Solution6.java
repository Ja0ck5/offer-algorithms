package com.lyj.algorithms.tree;

/**
 * �����������
 * 
 * ����һ�ö������ĸ���㣬���������ȡ�
 * 
 * �Ӹ���㵽Ҷ������ξ��� �Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ�������
 * 
 * @author Ja0ck5
 *
 */
public class Solution6 {
	
	public static class BinaryTreeNode{
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
		Solution6 s6 = new Solution6();
		System.out.println(s6.treeDepth(root));
	}

	public int treeDepth(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		return (left > right) ? left + 1 : right + 1;
	}

}
