package com.lyj.algorithms.number;

/**
 * 约瑟夫环问题 圆圈中最后剩下的数字
 * 
 * 0,1， ...,n-1 这 n 个数排成一个圆圈，从数字 0 开始每次从这个圆圈里 删除第 m 个数字。求出这个圆圈里剩下的最后一个数字。
 * 
 * 在这 n个数字中， 第一个被删除的数字是(m-1)%n。为了简单起见，我们把(m- 1)%n 记为 k，
 * 那么删除k之后剩下的 n-1 个数字为 0，1，…，k-1，k+1，… ，n-1，并且下一次删除从数字 k+1 开始计数。
 * 相当于在剩下的序列中， k+1 排在最前面，从而形成 k+1，... ，n-1，0，I，… ，k-1 。
 * 该序列最后剩下的数字也应该是关于 n 和 m 的函数。由于这个序列的规律和前面最初的序列不一样（最初的序列是从 0开始的连续序列），
 * 
 * 因此该函数不同于前面的函数，记为 f’(n-1,m)。最初序列最后剩下的数字 f(n,m）一定是删除一个数字之后的序列最后剩下的数字，即 f(n, m)=f’(n-1, m）。
 * 
 * @author Ja0ck5
 *
 */
public class Solution7 {
	public static void main(String[] args) {
		Solution7 s7 = new Solution7();
		System.out.println(s7.lastRemaining(6, 3));
		
		int n = 21;
		int cnt=0;
		while(n !=0 ){
			n &=(n-1);
			cnt++;
		}
		System.out.println(cnt);
	}

	public int lastRemaining(int n, int m) {
		if (n < 1 || m < 1)
			return -1;
		int last = 0;
		for (int i = 2; i <= n; i++)
			last = (last + m) % i;
		return last;
	}
}
