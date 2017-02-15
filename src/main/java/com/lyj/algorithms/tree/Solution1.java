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
		boolean flag = false;
		if(null != btn1 && null != btn2){
			// ���ڵ���ͬ
			if(btn1.val == btn2.val)
				flag = doseTree1HaveTree2(btn1,btn2);
			//���ڵ㲻ͬ�����ж�  ���ӽڵ�
			if(!flag)
				flag = doseTree1HaveTree2(btn1.left, btn2);
			if(!flag)
				flag = doseTree1HaveTree2(btn1.right, btn2);
		}
		return flag;
	}
	
	private static boolean doseTree1HaveTree2(BinaryTreeNode btn1, BinaryTreeNode btn2) {
		//1 ������� btn2 Ϊ�գ��� btn1 ���� btn2
		if(null == btn2)
			return true;
		//2 ����� 1 Ϊ���򲻰�����2
		if( null == btn1)
			return false;
		//3 ������ڵ�ֵ����ȣ��򲻰���
		if(btn1.val != btn2.val)
			return false;
		//4 �ж϶�Ӧ�����ҽڵ��ֵ�Ƿ�������
		return doseTree1HaveTree2(btn1.left, btn2.left) && doseTree1HaveTree2(btn1.right, btn2.right);
	}
	
	public static void main(String[] args) {
		
	}

}
