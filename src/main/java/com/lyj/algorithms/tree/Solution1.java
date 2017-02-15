package com.lyj.algorithms.tree;


/**
 * 树的子结构
 * 输入两颗二叉树 A 和 B，判断 B 是不是 A 的子结构
 * @author Ja0ck5
 *
 */
public class Solution1 {
	public static class BinaryTreeNode {
		// 节点值
		 int val;
		// 左节点
		BinaryTreeNode left;
		// 右节点
		BinaryTreeNode right;

		public BinaryTreeNode() {}

		public BinaryTreeNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "BinaryTreeNode [val=" + val + " left=" + left + ", right=" + right + "]";
		}
	}
	
	public static boolean hasSubTree(BinaryTreeNode btn1,BinaryTreeNode btn2){
		boolean flag = false;
		if(null != btn1 && null != btn2){
			// 根节点相同
			if(btn1.val == btn2.val)
				flag = doseTree1HaveTree2(btn1,btn2);
			//根节点不同，则判断  左子节点
			if(!flag)
				flag = doseTree1HaveTree2(btn1.left, btn2);
			if(!flag)
				flag = doseTree1HaveTree2(btn1.right, btn2);
		}
		return flag;
	}
	
	private static boolean doseTree1HaveTree2(BinaryTreeNode btn1, BinaryTreeNode btn2) {
		//1 如果子树 btn2 为空，则 btn1 包含 btn2
		if(null == btn2)
			return true;
		//2 如果树 1 为空则不包含树2
		if( null == btn1)
			return false;
		//3 如果两节点值不相等，则不包含
		if(btn1.val != btn2.val)
			return false;
		//4 判断对应的左右节点的值是否各自相等
		return doseTree1HaveTree2(btn1.left, btn2.left) && doseTree1HaveTree2(btn1.right, btn2.right);
	}
	
	public static void main(String[] args) {
		
	}

}
