package com.lyj.algorithms.linkedlist;

import java.awt.List;

/**
 * �ϲ�������������� ��������������������� �ϲ�����������ʹ�������еĽ����Ȼ�ǰ��յ�������ġ�
 * 
 * @author Ja0ck5
 *
 */
public class Solution6 {

	public static class ListNode {
		int val;
		ListNode nxt;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", nxt=" + nxt + "]";
		}
	}

	public static ListNode mergeListNode(ListNode ln1, ListNode ln2) {
		if (null == ln1)
			return ln2;
		if (null == ln2)
			return ln1;

		ListNode mergement = null;

		if (ln1.val < ln2.val) {
			// ������ ln1 ��һ��Ԫ�ظ�ֵ�� �ϲ�����
			mergement = ln1;
			// ���´αȽϺ�������һ��Ԫ�ظ�ֵ�� �ϲ�����ָ����,����һ��
			mergement.nxt = mergeListNode(ln1.nxt, ln2);
		} else {
			mergement = ln2;
			mergement.nxt = mergeListNode(ln1, ln2.nxt);
		}
		return mergement;
	}

	public static ListNode mergeListNode2(ListNode ln1, ListNode ln2) {
		if (null == ln1)
			return ln2;
		if (null == ln2)
			return ln1;
		ListNode tmp1 = ln1;
		ListNode tmp2 = ln2;
		ListNode head = new ListNode(0);
		ListNode headTmp = head;
		while (tmp1 != null && tmp2 != null) {

			if (tmp1.val <= tmp2.val) {
				head.nxt = tmp1;
				head = head.nxt;
				tmp1 = tmp1.nxt;
			} else {
				head.nxt = tmp2;
				head = head.nxt;
				tmp2 = tmp2.nxt;
			}

		}
		while (tmp1 != null) {
			head.nxt = tmp1;
			head = head.nxt;
			tmp1 = tmp1.nxt;
		}
		while (tmp2 != null) {
			head.nxt = tmp2;
			head = head.nxt;
			tmp2 = tmp2.nxt;
		}

		head = headTmp.nxt;
		return head;
	}

	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ln1.nxt = new ListNode(3);
		ln1.nxt.nxt = new ListNode(5);
		ListNode ln2 = new ListNode(2);
		ln2.nxt = new ListNode(4);
		ln2.nxt.nxt = new ListNode(6);

		System.out.println(mergeListNode(ln1, ln2));

	}

}
