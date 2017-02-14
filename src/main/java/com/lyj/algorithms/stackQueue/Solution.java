package com.lyj.algorithms.stackQueue;

import java.util.Stack;

/**
 * 用两个栈实现一个队列，实现对了的两个函数 
 * 
 * appendTail 和
 * 
 * deleteHead，
 * 
 * 分别完成在队列尾插入结点和在队列头部删除结点的功能。
 * 
 * @author Ja0ck5
 *
 */
public class Solution<T> {
	
	//
	private Stack<T> s1 = new Stack<T>();
	private Stack<T> s2 = new Stack<T>();
	//appendTail
	public void appendTail(T t){
		s1.push(t);
	}
	
	//deleteHead
	public T deleteHead(){
		if(s2.isEmpty()){
			while(!s1.isEmpty())
				s2.push(s1.pop());
		}
		if(s2.isEmpty())
			throw new RuntimeException("The queue is empty ,can not be delete");
		return s2.pop();
	}
	
	public static void main(String[] args) {
		Solution<String> s=new Solution<>();
		s.appendTail("1");
		s.appendTail("2");
		s.appendTail("3");
		System.out.println(s.deleteHead());
	}
}
