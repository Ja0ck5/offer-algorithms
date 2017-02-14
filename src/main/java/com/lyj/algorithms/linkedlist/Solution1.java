package com.lyj.algorithms.linkedlist;
/**
 * ����һ�������ͷ��㣬��β��ͷ��������ӡ��ÿ������ֵ
 * 
 * �ݹ�ķ�ʽ
 * @author Ja0ck5
 *
 */
public class Solution1 {
	
	/** 
     * ������ 
     */  
    public static class ListNode {  
        int val; // ����ֵ  
        ListNode nxt; // ��һ�����  
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
