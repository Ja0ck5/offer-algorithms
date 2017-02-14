package com.lyj.algorithms;

/**
 * ì³²¨ÄÇÆõÊýÁÐ
 * @author Ja0ck5
 *
 */
public class Fibonacci {
	private static long fibonacci(long n){
	    if(0 >= n) return n;
	    if(1 == n || 2 == n) return 1;

	    long prev = 1;
	    long next = 1;
	    long result = 0;
	    while(n > 2){
	        result = prev + next;
	        prev   = next;
	        next   = result;
	        n--;
	    }
	    return result;
	}
	
	private static int fibonacci1(int n) {
	    if (0 == n)
	        return 0;
	    if (1 == n)
	        return 1;
	    return fibonacci1(n - 1) + fibonacci1(n - 2);
	}
	
	private static int fibonacci2(int n) {
	    if (0 == n) return 0;
	    if (1 == n) return 1;

	    if (2 < n) {
	        int[] arr = new int[n + 1];
	        arr[0] = 0;
	        arr[1] = 1;
	        for (int i = 2; i < arr.length; i++) {
	            arr[i] = arr[i - 1] + arr[i - 2];
	        }
	        return arr[n];
	    }
	    return n;
	}
}
