package com.lyj.algorithms.sigleton.normal;

/**
 * 饿汉
 * @author Ja0ck5
 *
 */
public class Singleton {
	//私有
	private static final Singleton INSTANCE = new Singleton();
	//私有构造函数
	private Singleton(){}
	
	//提供调用
	public static Singleton getInstance(){
		return INSTANCE;
	}

}
