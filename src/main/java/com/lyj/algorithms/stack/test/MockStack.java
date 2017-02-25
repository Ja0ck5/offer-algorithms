package com.lyj.algorithms.stack.test;

public class MockStack<T> {
	private int size;
	private int top;
	private T[] arr;

	public MockStack(int size) {
		this.size = size;
		this.top = -1;
		this.arr = (T[]) new Object[this.size];
	}

	public void push(T t) {
		if (!isFull())
			arr[++top] = t;
	}

	public T pop() {
		if (isEmpty())
			return null;
		return arr[top--];
	}

	public T peek() {
		return arr[top];
	}

	public boolean isFull() {
		return top == this.size - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

}
