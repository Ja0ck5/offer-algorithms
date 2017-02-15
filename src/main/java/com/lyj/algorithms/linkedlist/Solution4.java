package com.lyj.algorithms.linkedlist;

/**
 * �����е����� k �����
 * ����һ����������������е����� k ����㡣
 * Ϊ�˷��ϴ�����˵�ϰ�ߣ�
 * ����� 1 ��ʼ�������������β����ǵ�����һ����㡣
 * ����һ���� 6 ������������ͷ��������� 1,2,3,4,5,6 
 * ����������������ֵΪ 4 �Ľ�㡣
 * @author Ja0ck5
 */
public class Solution4 {
	//��������
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
		//�������жϳ���
		while(n.nxt != null ){
			len++;
			n = n.nxt;
		}
		//k Լ��
		if(k > len) return null;
		 //������k���ڵ�Ϊ˳��ĵ� len - k���ڵ�
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
        // �����ڶ����ڵ�
        System.out.println(findNok(listNode, 2));
	}

}
