package com.lyj.algorithms.sigleton.lazy;

/**
 * 懒汉
 * @author Ja0ck5
 *
 */
public class Singleton {
	
	private static Singleton instance = null;
	
	//私有构造器
	private Singleton(){}
	
	//提供公共调用
	public synchronized static Singleton getInstance(){
		if(null == instance)
			instance = new Singleton();
		return instance;
	}
	
}
