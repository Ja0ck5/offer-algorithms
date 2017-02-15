package com.lyj.algorithms.linkedlist;

/**
 * 链表中倒数第 k 个结点
 * 输入一个链表，输出该链表中倒数第 k 个结点。
 * 为了符合大多数人的习惯，
 * 本题从 1 开始计数，即链表的尾结点是倒数第一个结点。
 * 例如一个有 6 个结点的链表，从头结点依次是 1,2,3,4,5,6 
 * 倒数第三个结点就是值为 4 的结点。
 * @author Ja0ck5
 */
public class Solution4 {
	//构建链表
	public static class ListNode{
		int val;
		ListNode nxt;
		public ListNode() {}
		public ListNode(int val) {
			this.val = val;
		}
		@Override
		public String toString() {
			return "ListNode [val=" + val + ", nxt=" + nxt + "]";
		}
		
	}
	
	public static ListNode findNok(ListNode node,int k){
		if(null == node || k <= 0)
			return null;
		int len = 1;
		ListNode n = node;
		//遍历，判断长度
		while(n.nxt != null ){
			len++;
			n = n.nxt;
		}
		//k 约束
		if(k > len) return null;
		 //倒数第k个节点为顺序的第 len - k个节点
        n = node;
        for(int i = 1;i <= len - k;i ++)
            n = n.nxt;
        return n;
	}
	
	public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.nxt = new ListNode(2);
        listNode.nxt.nxt = new ListNode(3);
        listNode.nxt.nxt.nxt = new ListNode(4);
        // 倒数第二个节点
        System.out.println(findNok(listNode, 2));
	}

}
