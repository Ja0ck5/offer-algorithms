package com.lyj.algorithms;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		
		ThreadLocal<Object> threadLocal = new ThreadLocal<>();
		threadLocal.set("123");
		/*for (Integer i : arrayList) {
			System.out.println(arrayList.get(i));
			arrayList.remove(i);//java.util.ConcurrentModificationException
		}*/
		
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
			arrayList.remove(i);
			i--;
		}
		
		Iterator<Integer> iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.remove();
		}
		
		System.out.println(arrayList.toString());
		
	}

}