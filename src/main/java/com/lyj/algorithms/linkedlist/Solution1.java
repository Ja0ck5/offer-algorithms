package com.lyj.algorithms.linkedlist;
/**
 * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值
 * 
 * 递归的方式
 * @author Ja0ck5
 *
 */
public class Solution1 {
	
	/** 
     * 结点对象 
     */  
    public static class ListNode {  
        int val; // 结点的值  
        ListNode nxt; // 下一个结点  
    } 
	
	public static void printListReverse(ListNode headNode){
		if (headNode != null) {  
			printListReverse(headNode.nxt);  
            System.out.print(headNode.val + " ");  
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
	        printListReverse(head);  
	}

}
