package com.lyj.algorithms.number;

/**
 * 从 1 到 n 整数中 1 出现的次数
 * 
 * 输入一个整数 n，求从 1 到 n 这 n 个整数的十进制表示中 1 出现的次 数。例如输入 12，这些整数中包含 1 的数字有 1,10,11,12，
 * 1 一共出现了 5 次。
 * 
 * @author Ja0ck5
 *
 */
public class Solution4 {
	public static void main(String[] args) {
		Solution4 s1 = new Solution4();
		System.out.println(s1.countDigitOne(123));
	}

	/** 
	 *   Go through the digit positions by using position multiplier m with values 1, 10, 100, 1000, etc.
	 *   
	 *   For each position, split the decimal representation into two parts, 
	 *   
	 *   for example split n=3141592 into a=31415 and b=92 when we're at m=100 for analyzing the hundreds-digit. 
	 *   
	 *   And then we know that the hundreds-digit of n is 1 for prefixes "" to "3141", i.e., 3142 times. 
	 *   
	 *   Each of those times is a streak, though. 
	 *   
	 *   Because it's the hundreds-digit, each streak is 100 long. So (a / 10 + 1) * 100 times, the hundreds-digit is 1.
	 *   
	 *   Consider the thousands-digit, i.e., when m=1000. 
	 *   
	 *   Then a=3141 and b=592. The thousands-digit is 1 for prefixes "" to "314", so 315 times. 
	 *   
	 *   And each time is a streak of 1000 numbers. However, since the thousands-digit is a 1, the very last streak isn't 1000 numbers but only 593 numbers, for the suffixes "000" to "592". So (a / 10 * 1000) + (b + 1) times, the thousands-digit is 1.
	 *   
	 *   The case distincton between the current digit/position being 0, 1 and >=2 can easily be done in one expression. 
	 *   
	 *   With (a + 8) / 10 you get the number of full streaks, and a % 10 == 1 tells you whether to add a partial streak.
	 *   
	 *   主要思路：设定整数点（如1、10、100等等）作为位置点i（对应n的各位、十位、百位等等），分别对每个数位上有多少包含1的点进行分析
	 * 
	 *   根据设定的整数位置，
	 * 
	 *   对n进行分割，分为两部分，高位n/i，低位n%i
	 *   
	 *   当i表示百位，且百位对应的数>=2,如n=31456,i=100，则a=314,b=56，此时百位为1的次数有a/10+1=32  【1】（最高两位0~31），每一次都包含100个连续的点，即共有(a/10+1)*100个点的百位为1
	 *  
	 *   当i表示百位，且百位对应的数为1，如n=31156,i=100，则a=311,b=56，此时百位对应的就是1，则共有 a/10(最高两位0-30)次是包含100个连续点，
	 *   
	 *   当最高两位为31（即a=311），本次只对应局部点00~56，共b+1次，所有点加起来共有（a/10*100）+(b+1)，这些点百位对应为1
	 *   
	 *   当i表示百位，且百位对应的数为0,如n=31056,i=100，则a=310,b=56，此时百位为1的次数有a/10=31 【2】（最高两位0~30）
	 *   
	 *   综合以上三种情况，当百位对应0或>=2时，有(a+8)/10次包含所有100个点，还有当百位为1(a%10==1)，需要增加局部点b+1
	 *    
	 *   之所以补8，是因为当百位为0，则a/10==(a+8)/10，(310+8)/10  (314+8)/10 效果等同于 以上的【1】【2】,当百位>=2，补8会产生进位位，效果等同于(a/10+1)
	 *   
	
	 */
	public int countDigitOne(int n) {
		int ones = 0;
		for (long m = 1; m <= n; m *= 10)
			ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
		return ones;
	}

}
