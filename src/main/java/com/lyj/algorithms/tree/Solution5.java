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
