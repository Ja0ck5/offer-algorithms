package com.lyj.algorithms.number;

/**
 * Լɪ������ ԲȦ�����ʣ�µ�����
 * 
 * 0,1�� ...,n-1 �� n �����ų�һ��ԲȦ�������� 0 ��ʼÿ�δ����ԲȦ�� ɾ���� m �����֡�������ԲȦ��ʣ�µ����һ�����֡�
 * 
 * ���� n�������У� ��һ����ɾ����������(m-1)%n��Ϊ�˼���������ǰ�(m- 1)%n ��Ϊ k��
 * ��ôɾ��k֮��ʣ�µ� n-1 ������Ϊ 0��1������k-1��k+1���� ��n-1��������һ��ɾ�������� k+1 ��ʼ������
 * �൱����ʣ�µ������У� k+1 ������ǰ�棬�Ӷ��γ� k+1��... ��n-1��0��I���� ��k-1 ��
 * ���������ʣ�µ�����ҲӦ���ǹ��� n �� m �ĺ���������������еĹ��ɺ�ǰ����������в�һ��������������Ǵ� 0��ʼ���������У���
 * 
 * ��˸ú�����ͬ��ǰ��ĺ�������Ϊ f��(n-1,m)������������ʣ�µ����� f(n,m��һ����ɾ��һ������֮����������ʣ�µ����֣��� f(n, m)=f��(n-1, m����
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
