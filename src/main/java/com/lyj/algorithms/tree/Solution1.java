package com.lyj.algorithms.tree;


/**
 * �����ӽṹ
 * �������Ŷ����� A �� B���ж� B �ǲ��� A ���ӽṹ
 * @author Ja0ck5
 *
 */
public class Solution1 {
	public static class BinaryTreeNode {
		// �ڵ�ֵ
		 int val;
		// ��ڵ�
		BinaryTreeNode left;
		// �ҽڵ�
		BinaryTreeNode right;

		public BinaryTreeNode() {}

		public BinaryTreeNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "BinaryTreeNode [val=" + val + " left=" + left + ", right=" + right + "]";
		}
	    
	}
	public static boolean hasSubTree(BinaryTreeNode btn1,BinaryTreeNode btn2){
		
		return false;
	}

}
