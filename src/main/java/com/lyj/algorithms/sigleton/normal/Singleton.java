package com.lyj.algorithms.sigleton.normal;

/**
 * ����
 * @author Ja0ck5
 *
 */
public class Singleton {
	//˽��
	private static final Singleton INSTANCE = new Singleton();
	//˽�й��캯��
	private Singleton(){}
	
	//�ṩ����
	public static Singleton getInstance(){
		return INSTANCE;
	}

}
