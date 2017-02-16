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

	class BinaryNode {
		int val;
		BinaryNode left;
		BinaryNode right;

		public BinaryNode() {
		}

		public BinaryNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "BinaryNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
	}

	public static boolean isBackSequenceTree(int[] sequence) {
		if (sequence.length == 0)
			return false;
		if (sequence.length == 1)
			return true;
		return judge(sequence, 0, sequence.length - 1);

	}

	public static boolean judge(int[] a, int l, int r) {
		if (l >= r)
			return true;
		int i = r;
		// �Ӻ��濪ʼ��
		while (i > l && a[i - 1] > a[r])
			i--;// �ҵ��ȸ�С������
		// ��ǰ�濪ʼ�� l ��i-1Ӧ�ñȸ�С
		for (int j = l; j < i - 1; j++)
			//��ڵ�ȸ��ڵ���� false
			if (a[j] > a[r])
				return false;
		//���ж����������Ƿ���� ������� �� ����������
		return judge(a, l, i - 1) && judge(a, i, r - 1);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 5, 7, 6, 9, 11, 10, 8 };
		int[] b = new int[] { 7, 4, 6, 5 };
		int[] c = new int[] { 11, 10, 9, 8 };
		System.out.println(isBackSequenceTree(a));
//		System.out.println(isBackSequenceTree(b));
//		System.out.println(isBackSequenceTree(c));
	}

}
