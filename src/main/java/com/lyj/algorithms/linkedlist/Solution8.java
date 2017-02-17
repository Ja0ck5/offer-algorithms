package com.lyj.algorithms.linkedlist;

/**
 * 两个链表的第一个公共结点
 * 
 * 输入两个链表，找出它们的第一个公共结点。
 * 
 * @author Ja0ck5
 *
 */
public class Solution8 {

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

	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		ListNode second1 = new ListNode(2);
		ListNode third1 = new ListNode(3);
		ListNode forth1 = new ListNode(6);
		ListNode fifth1 = new ListNode(7);
		ListNode head2 = new ListNode(4);
		ListNode second2 = new ListNode(5);
		ListNode third2 = new ListNode(6);
		ListNode forth2 = new ListNode(7);
		head1.nxt = second1;
		second1.nxt = third1;
		third1.nxt = forth1;
		forth1.nxt = fifth1;
		head2.nxt = second2;
		second2.nxt = forth1;
		third2.nxt = fifth1;
		Solution8 test = new Solution8();
		System.out.println(test.findFirstCommonNode(head1, head2).val);
	}

	public ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
		int len1 = getListLength(head1);
		int len2 = getListLength(head2);
		ListNode longNode = null;
		ListNode shortNode = null;
		int dif = 0;
		if (len1 > len2) {
			longNode = head1;
			shortNode = head2;
			dif = len1 - len2;
		} else {
			longNode = head2;
			shortNode = head1;
			dif = len2 - len1;
		}
		
		for (int i = 0; i < dif; i++) {
			longNode = longNode.nxt;
		}
		
		while (longNode != null && shortNode != null && longNode != shortNode) {
			longNode = longNode.nxt;
			shortNode = shortNode.nxt;
		}
		
		return longNode;
	}

	private int getListLength(ListNode head1) {
		int rst = 0;
		if (head1 == null)
			return rst;
		ListNode p = head1;
		while (p != null) {
			p = p.nxt;
			rst++;
		}
		return rst;
	}

}
