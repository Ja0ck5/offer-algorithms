package com.lyj.algorithms.linkedlist;

/**
 * 反转链表
 * 定义一个函数，输入一个链表的头结点
 * 反转该链表并输出反转后链表的头结点。
 * @author Ja0ck5
 *
 */
public class Solution5 {
	
	//构建链表
	public  static class ListNode{
		int val;
		ListNode nxt;
		public ListNode(int val) {
			this.val = val;
		}
		public ListNode() {}
		@Override
		public String toString() {
			return "ListNode [val=" + val + ", nxt=" + nxt + "]";
		}
	}
	
	public static ListNode reverseListNode(ListNode root){
		if(null == root)
			return null;
		ListNode prev = root;
		ListNode cur  = root.nxt;
		ListNode nxt;
		while(null != cur){
			// 反转.当前指向的下一个，反转指向当前
			 nxt = cur.nxt;
			 cur.nxt = prev;
			 // 下一次的 上一个 为这次的 当前 。
			 prev = cur;  
			 //下一次的 当前 为这次的 下一个
	         cur = nxt; 
		}
		//将原链表的头节点的下一个节点置为null
        root.nxt = null;
        //再将反转后的头节点赋给root  
        root = prev;  
		return root;
	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		listNode.nxt = new ListNode(2);
		listNode.nxt.nxt = new ListNode(3);
		listNode.nxt.nxt.nxt = new ListNode(4);
		
		System.out.println(reverseListNode(listNode));
	}
}
