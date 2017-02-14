package com.lyj.algorithms.linkedlist;

import java.util.Stack;

import com.lyj.algorithms.linkedlist.Solution1.ListNode;
/**
 * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值
 * 
 * 非递归的方式
 * @author Ja0ck5
 *
 */
public class Solution2 {
	
	public static class ListNode{
		int val;
		ListNode nxt;
	}
	
	public static void printListNodeReverse(ListNode headNode){
		// 栈 先进后出
		Stack<ListNode> stack = new Stack<ListNode>();
		//push
		while(null != headNode){
			stack.push(headNode);
			headNode = headNode.nxt;
		}
		//pop
		while(!stack.isEmpty()){
			System.out.print(stack.pop().val);
		}
	}
	
	public static void main(String[] args) {
		 	ListNode head = new ListNode();  
	        head.val = 1;  
	        head.nxt = new ListNode();  
	        head.nxt.val = 2;  
	        head.nxt.nxt = new ListNode();  
	        head.nxt.nxt.val = 3;  
	        head.nxt.nxt.nxt = new ListNode();  
	        head.nxt.nxt.nxt.val = 4;  
	        head.nxt.nxt.nxt.nxt = new ListNode();  
	        head.nxt.nxt.nxt.nxt.val = 5;  
	        printListNodeReverse(head);  
	}

}
