package com.lyj.algorithms.linkedlist;

import com.lyj.algorithms.linkedlist.Solution6.ListNode;

/**
 * 复杂链表的复制
 * 
 * 实现函数复制一个复杂链表。
 * 
 * 在复杂链表中，每个结点除了有一个 next 指针指向下一个结点外，还有一个指向链表中任意结点或 null。
 * 
 * 
 * 1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
 * 
 * 2、遍历链表，A1->random = A->random->next;
 * 
 * 3、将链表拆分成原链表和复制后的链表
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
	        //1  复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
	        while(pCur!=null){
	        	ComplexListNode node = new ComplexListNode(pCur.val);
	            node.nxt = pCur.nxt;
	            pCur.nxt = node;
	            pCur = node.nxt;
	        }
	        pCur = pHead;
	        //2  复制sibling pCur是原来链表的结点 pCur.next是复制pCur的结点
	        while(pCur!=null){
	            if(pCur.sibling!=null)
	                pCur.nxt.sibling = pCur.sibling.nxt;
	            pCur = pCur.nxt.nxt;
	        }
	        ComplexListNode head = pHead.nxt;
	        ComplexListNode cur = head;
	        pCur = pHead;
	        //3 拆分链表
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
