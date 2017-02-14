package com.lyj.algorithms.sigleton.staticinnerclass;

/**
 * ��Ϊ SingletonHolder ��û�б�����ʹ��
 * ֻ����ʾͨ������ getInstance ����ʱ
 * �Ż���ʾװ�� SingletonHolder ��
 * �Ӷ�ʵ���� instance
 * 
 * �̰߳�ȫ
 * 
 * �Ǽ�ʽ
 * 
 * ��̬�ڲ���
 * @author Ja0ck5
 *
 */
public class Singleton {

	// 1
	private Singleton() {
	}

	// 2 ��̬�ڲ���
	private static class SingletonHolder {
		private static final Singleton INSTANCE = new Singleton();
	}
	
	// 3 �ṩ�ⲿ�ĵ���
	public static Singleton getInstance(){
		return SingletonHolder.INSTANCE;
	}

}
