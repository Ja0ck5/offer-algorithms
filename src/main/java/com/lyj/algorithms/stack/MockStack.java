package com.lyj.algorithms.stack;

/**
 * 模拟栈
 * @author Ja0ck5
 *
 * @param <T>
 */
public class MockStack<T> {
	
	private int size;
	private int top;//栈顶索引
	private T[] arr;//实际存储的数组
	
	/**
	 * 初始化栈
	 * @param size 栈大小
	 */
	public MockStack(int size) {
		this.size = size;
		this.top = -1;
		this.arr = (T[]) new Object[this.size];
	}
	
	/**
	 * 出栈
	 * @return
	 */
	public T pop() {
		if(isEmpty())
			return null;
		return arr[top--];
	}

	public void push(T t){
		if(!isFull())
			arr[++top] = t;
	}
	
	
	public boolean isFull() {
		return top == size-1;
	}

	public boolean isEmpty() {
		return -1 == top;
	}
	
	public int size(){
		return top+1;
	}
	
	
	
	

}
