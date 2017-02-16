package com.lyj.algorithms.linkedlist;

/**
 * ��������ĸ���
 * 
 * ʵ�ֺ�������һ����������
 * 
 * �ڸ��������У�ÿ����������һ�� next ָ��ָ����һ������⣬����һ��ָ��������������� null��
 * 
 * 
 * 1������ÿ���ڵ㣬�磺���ƽڵ�A�õ�A1����A1����ڵ�A����
 * 
 * 2����������A1->random = A->random->next;
 * 
 * 3���������ֳ�ԭ����͸��ƺ������
 * 
 * @author Ja0ck5
 *
 */
public class Solution7 {

	class ComplexListNode {
		int val;
		ComplexListNode next;
		ComplexListNode sibling;

		public ComplexListNode(int val) {
			this.val = val;
		}

		public ComplexListNode() {
		}

		@Override
		public String toString() {
			return "ComplexListNode [val=" + val + ", next=" + next + ", sibling=" + sibling + "]";
		}
	}

}
