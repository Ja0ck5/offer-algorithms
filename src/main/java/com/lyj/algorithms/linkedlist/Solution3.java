package com.lyj.algorithms.linkedlist;

/**
 * 在 O（ 1）时间删除链表结点 给定单向链表的头指针和一个结点指针，定义一个函数在 O(1)时间删除该结点。
 * 
 * @author Ja0ck5
 *
 */
public class Solution3 {

	static class ListNode {
		int val;
		ListNode nxt;

		ListNode(int v) {
			this.val = v;
		}
	}

	public static ListNode deleteNode(ListNode head, ListNode deletedNode) {
		if (deletedNode == null || head == null)
			return null;

		// 不是尾结点
		if (deletedNode.nxt != null) {
			//将下个节点赋值给当前节点，达到删除当前节点的效果
			ListNode node = deletedNode.nxt;
			deletedNode.val = node.val;
			deletedNode.nxt = node.nxt;

			node = null;
		}else if (head == deletedNode) {
			// 只有一个结点，删除头结点
			deletedNode = null;
			head = null;
			return null;
		} else {
			// 多个结点，删除尾结点
			ListNode node = head;
			while (node.nxt != deletedNode) {
				node = node.nxt;
			}
			node.nxt = null;
			deletedNode = null;
		}
		return head;
	}
	
	public static void print(ListNode head){
        if(head == null)
            System.out.println("list is null");
        while(head != null){
            System.out.println(head.val);
            head = head.nxt;
        }
    }
    public static void main(String[] args) {

        //测试代码
        ListNode head = null;
        print(deleteNode(head, head));
        head = new ListNode(0);
        ListNode p = head;

        for(int i = 1; i < 5; i++){
            ListNode node = new ListNode(i);
            p.nxt = node;
            p = p.nxt;
        }

        ListNode tail = new ListNode(5);
        p.nxt = tail;

        print(head);

        //(3)只有一个结点，删除尾结点(也是头结点)
        print(deleteNode(head, head));

        //(2)多个结点，删除尾结点
        print(deleteNode(head, tail));

        //(1)删除的不是尾结点
        print(deleteNode(head, head.nxt));



    }
}
