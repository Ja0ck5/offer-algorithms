package com.lyj.algorithms.linkedlist;

import com.lyj.algorithms.linkedlist.Solution6.ListNode;

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

	static class ComplexListNode {
		int val;
		ComplexListNode nxt;
		ComplexListNode sibling;
		public ComplexListNode(int val) {
			this.val = val;
		}

		public ComplexListNode() {
		}
		@Override
		public String toString() {
			return "ComplexListNode [val=" + val + ", next=" + nxt + ", sibling=" + sibling + "]";
		}
	}
	
	 public static ComplexListNode clone(ComplexListNode pHead){
	        if(pHead==null)
	            return null;
	        ComplexListNode pCur = pHead;
	        //1  ����next ��ԭ����A->B->C ���A->A'->B->B'->C->C'����ÿ���ڵ㣬�磺���ƽڵ�A�õ�A1����A1����ڵ�A����
	        while(pCur!=null){
	        	ComplexListNode node = new ComplexListNode(pCur.val);
	            node.nxt = pCur.nxt;
	            pCur.nxt = node;
	            pCur = node.nxt;
	        }
	        pCur = pHead;
	        //2  ����sibling pCur��ԭ������Ľ�� pCur.next�Ǹ���pCur�Ľ��
	        while(pCur!=null){
	            if(pCur.sibling!=null)
	                pCur.nxt.sibling = pCur.sibling.nxt;
	            pCur = pCur.nxt.nxt;
	        }
	        ComplexListNode head = pHead.nxt;
	        ComplexListNode cur = head;
	        pCur = pHead;
	        //3 �������
	        while(pCur!=null){
	            pCur.nxt = pCur.nxt.nxt;
	            if(cur.nxt!=null)
	                cur.nxt = cur.nxt.nxt;
	            cur = cur.nxt;
	            pCur = pCur.nxt;
	        }
	        return head;       
	    }
	 
//---------------------------------------------- way 2 -----------------------------------------------//
	 
	 // way 2
	 public ComplexListNode clone2(ComplexListNode head) {
			cloneNodes(head);
			connectSiblingNodes(head);
			return reconnectNodes(head);
		}

		public void cloneNodes(ComplexListNode head) {
			ComplexListNode node = head;
			while (node != null) {
				ComplexListNode cloneNode = new ComplexListNode();
				cloneNode.val = node.val;
				cloneNode.nxt = node.nxt;
				cloneNode.sibling = null;
				node.nxt = cloneNode;
				node = cloneNode.nxt;
			}
		}

		public void connectSiblingNodes(ComplexListNode head) {
			ComplexListNode node = head;
			while (node != null) {
				ComplexListNode clonedNode = node.nxt;
				if (node.sibling != null) {
					clonedNode.sibling = node.sibling.nxt;
				}
				node = clonedNode.nxt;
			}
		}

		public ComplexListNode reconnectNodes(ComplexListNode head) {
			ComplexListNode node = head;
			ComplexListNode clonedHead = null;
			ComplexListNode clonedNode = null;
			if (node != null) {
				clonedNode = node.nxt;
				clonedHead = clonedNode;
				node.nxt = clonedNode.nxt;
				node = node.nxt;
			}
			while (node != null) {
				clonedNode.nxt = node.nxt;
				clonedNode = clonedHead.nxt;
				node.nxt = clonedNode.nxt;
				node = node.nxt;
			}
			return clonedHead;
		}

	 public static void main(String[] args) {
		 ComplexListNode ln1 = new ComplexListNode(1);
			ln1.nxt = new ComplexListNode(3);
			ln1.nxt.nxt = new ComplexListNode(5);
			ln1.nxt.sibling = new ComplexListNode(7);
			ln1.nxt.nxt.sibling = new ComplexListNode(9);

			System.out.println(ln1);
			System.out.println(clone(ln1));
	}
}
