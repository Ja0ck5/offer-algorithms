package com.lyj.algorithms.stack;
public class StackS<T> {  
    private int max;  
    private T[] ary;  
    private int top;    //ָ�룬ָ��ջ��Ԫ�ص��±�  
      
    public StackS(int size) {  
        this.max = size;  
        ary = (T[]) new Object[max];  
        top = -1;  
    }  
      
    // ��ջ  
    public void push(T data) {  
        if (!isFull())  
            ary[++top] = data;  
    }  
      
    // ��ջ  
    public T pop() {  
        if (isEmpty())
            return null;  
        return ary[top--];  
    }  
      
    // �鿴ջ��  
    public T peek() {  
        return ary[top];  
    }  
      
    //ջ�Ƿ�Ϊ��  
    public boolean isEmpty() {  
        return top == -1;  
    }  
      
    //ջ�Ƿ���  
    public boolean isFull() {  
        return top == max - 1;  
    }  
      
    //size  
    public int size() {  
        return top + 1;  
    }  
      
    public static void main(String[] args) {  
        StackS<Integer> stack = new StackS<Integer>(3);  
        for (int i = 0; i < 5; i++) {  
            stack.push(i);  
            System.out.println("push size:" + stack.size());  
        }  
        for (int i = 0; i < 5; i++) {  
            Integer peek = stack.peek();  
            System.out.println("peek:" + peek);  
            System.out.println("peek size:" + stack.size());  
        }  
        for (int i = 0; i < 5; i++) {  
            Integer pop = stack.pop();  
            System.out.println("pop:" + pop);  
            System.out.println("pop size:" + stack.size());  
        }  
          
    }  
}  