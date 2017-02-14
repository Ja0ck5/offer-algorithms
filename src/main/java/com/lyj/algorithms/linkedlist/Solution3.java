package com.lyj.algorithms.linkedlist;

/**
 * �� O�� 1��ʱ��ɾ�������� �������������ͷָ���һ�����ָ�룬����һ�������� O(1)ʱ��ɾ���ý�㡣
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

		// ����β���
		if (deletedNode.nxt != null) {
			//���¸��ڵ㸳ֵ����ǰ�ڵ㣬�ﵽɾ����ǰ�ڵ��Ч��
			ListNode node = deletedNode.nxt;
			deletedNode.val = node.val;
			deletedNode.nxt = node.nxt;

			node = null;
		}else if (head == deletedNode) {
			// ֻ��һ����㣬ɾ��ͷ���
			deletedNode = null;
			head = null;
			return null;
		} else {
			// �����㣬ɾ��β���
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

        //���Դ���
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

        //(3)ֻ��һ����㣬ɾ��β���(Ҳ��ͷ���)
        print(deleteNode(head, head));

        //(2)�����㣬ɾ��β���
        print(deleteNode(head, tail));

        //(1)ɾ���Ĳ���β���
        print(deleteNode(head, head.nxt));



    }
}
