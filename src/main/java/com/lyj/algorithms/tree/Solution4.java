package com.lyj.algorithms.tree;

/**
 * �����������ĺ���������� 
 * 
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ���� ���򷵻�true�����򷵻�false��
 * 
 * �����������ص㣺������һ����㣬��ֵ�������������н���ֵ��С�����������н���ֵ
 * 
 * @author Ja0ck5
 *
 */
public class Solution4 {

	class BinaryNode{
		int val;
		BinaryNode left;
		BinaryNode right;
		public BinaryNode() {}
		public BinaryNode(int val) {
			this.val = val;
		}
		@Override
		public String toString() {
			return "BinaryNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
	}
	
	public static boolean isBackSequenceTree(int[] seq){
		
		return false;
	}
	
}
