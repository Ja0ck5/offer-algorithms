package com.lyj.algorithms;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {

		
		Integer i2 = new Integer(2);
		Integer i3 = new Integer(3);
		swap(i2, i3);
		System.out.println("i2 = " + i2 + ", i3 = " + i3);

		StringBuilder a = new StringBuilder("a");
		StringBuilder b = new StringBuilder("b");

		System.out.println("a = " + a + ", b = " + b);

		foo(a, b);
		System.out.println("a = " + a + ", b = " + b);
		Date nowTime = new Date();
		System.out.println(nowTime);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH mm ss");
		String format = sdf.format(nowTime); System.out.println(format);
		 

		final Map<String, String> map = new HashMap<String, String>();
		map.put("a", "1");
		map.put("b", "2");
		map.put("c", "3");
		map.put("d", "4");
		map.put("e", "5");
		// print(map);
		
//		Executors.newScheduledThreadPool(10).scheduleAtFixedRate(new Runnable() {
//			@Override
//			public void run() {
//				System.err.println(Thread.currentThread().getName());
//			}
//		}, 2, 2, TimeUnit.SECONDS);
//		 	ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
	        ExecutorService threadPool2 = Executors.newCachedThreadPool();
//	        ExecutorService threadPool = Executors.newFixedThreadPool(10);
	        for (int i = 0; i < 100; i++) {
	            final int task = i;
	            threadPool2.execute(new Runnable() {
	                @Override
	                public void run() {
	                    for (int j = 1; j <= 10; j++) {
	                        try {
	                            Thread.sleep(20);
	                        } catch (InterruptedException e) {
	                            e.printStackTrace();
	                        }
	                        System.out.println(Thread.currentThread().getName()
	                                + " is looping of " + j + " for  task of "
	                                + task);
	                    }
	                }
	            });
	        }
		
	}

	private static void print(final Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet())
			System.out.println(entry.getKey() + " == " + entry.getValue());
	}

	private static void foo(StringBuilder a, StringBuilder b) {
		a.append(b);
		a = b;
	}

	private static void swap(Integer i2, Integer i3) {
		i2 ^= i3;
		i3 ^= i2;
		i2 ^= i3;
		System.out.println(" second i2 = " + i2 + ", i3 = " + i3);
	}
}