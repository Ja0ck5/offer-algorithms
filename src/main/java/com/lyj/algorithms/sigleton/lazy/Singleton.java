package com.lyj.algorithms.sigleton.lazy;

/**
 * ����
 * @author Ja0ck5
 *
 */
public class Singleton {
	
	private static Singleton instance = null;
	
	//˽�й�����
	private Singleton(){}
	
	//�ṩ��������
	public synchronized static Singleton getInstance(){
		if(null == instance)
			instance = new Singleton();
		return instance;
	}
	
}
