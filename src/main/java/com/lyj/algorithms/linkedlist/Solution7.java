package com.lyj.algorithms.linkedlist;

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
