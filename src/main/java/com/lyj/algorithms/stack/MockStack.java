package com.lyj.algorithms.stack;

/**
 * ģ��ջ
 * @author Ja0ck5
 *
 * @param <T>
 */
public class MockStack<T> {
	
	private int size;
	private int top;//ջ������
	private T[] arr;//ʵ�ʴ洢������
	
	/**
	 * ��ʼ��ջ
	 * @param size ջ��С
	 */
	public MockStack(int size) {
		this.size = size;
		this.top = -1;
		this.arr = (T[]) new Object[this.size];
	}
	
	/**
	 * ��ջ
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
