package com.lyj.algorithms.tree;

import java.util.ArrayList;
import java.util.List;


/**
 * �������к�Ϊĳһֵ��·�� ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ������������
 * ��·���������ĸ��ڵ㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
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
		//Ŀ��ֵ��ȥ������ֵ
		target -= root.val;
		if (target == 0 && root.left == null && root.right == null)
			listAll.add(new ArrayList<Integer>(list));
		//��ѯ��ڵ�
		findPath(root.left, target);
		//��ѯ�ҽڵ�
		findPath(root.right, target);
		//�Ƴ����һ��Ԫ��,��ȱ�����һ��·����Ҫ����
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
