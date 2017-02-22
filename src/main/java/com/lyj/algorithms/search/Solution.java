package com.lyj.algorithms.search;

/**
 * ¶þ·Ö²éÕÒ
 * @author Ja0ck5
 *
 */
public class Solution {
	
	public static int binarySearch(int[] a,int key){
		int lo = 0;
		int hi = a.length -1;
		while(lo <= hi){
			int mid = (hi+lo)/2;
			if(key == a[mid]) return mid;
			else if(key >= a[mid])
				lo = mid +1;
			else
				hi = mid -1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,5,7,8,9,12,34,56,78,90};
		System.out.println(binarySearch(a, 12));
	}
	
}
