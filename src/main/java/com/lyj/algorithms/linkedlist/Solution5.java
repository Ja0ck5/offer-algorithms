package com.lyj.algorithms.linkedlist;

/**
 * ��ת����
 * ����һ������������һ�������ͷ���
 * ��ת�����������ת�������ͷ��㡣
 * @author Ja0ck5
 *
 */
public class Solution5 {
	
	//��������
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
			// ��ת.��ǰָ�����һ������תָ��ǰ
			 nxt = cur.nxt;
			 cur.nxt = prev;
			 // ��һ�ε� ��һ�� Ϊ��ε� ��ǰ ��
			 prev = cur;  
			 //��һ�ε� ��ǰ Ϊ��ε� ��һ��
	         cur = nxt; 
		}
		//��ԭ�����ͷ�ڵ����һ���ڵ���Ϊnull
        root.nxt = null;
        //�ٽ���ת���ͷ�ڵ㸳��root  
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
