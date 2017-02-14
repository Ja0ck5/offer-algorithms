package com.lyj.algorithms.sigleton.staticinnerclass;

/**
 * 因为 SingletonHolder 类没有被主动使用
 * 只有显示通过调用 getInstance 方法时
 * 才会显示装载 SingletonHolder 类
 * 从而实例化 instance
 * 
 * 线程安全
 * 
 * 登记式
 * 
 * 静态内部类
 * @author Ja0ck5
 *
 */
public class Singleton {

	// 1
	private Singleton() {
	}

	// 2 静态内部类
	private static class SingletonHolder {
		private static final Singleton INSTANCE = new Singleton();
	}
	
	// 3 提供外部的调用
	public static Singleton getInstance(){
		return SingletonHolder.INSTANCE;
	}

}
