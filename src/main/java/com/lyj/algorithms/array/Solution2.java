package com.lyj.algorithms.array;

/**
 * ˳ʱ���ӡ����
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֡�
 * { 1, 2, 3, 4}
 * { 5, 6, 7, 8}
 * { 9,10,11,12}
 * {13,14,15,16}
 * 
 * 1,���Ҵ�ӡһ��  
 * 2,�ϵ��´�ӡһ��  
 * 3,�ҵ����ӡһ��  
 * 4,�µ��ϴ�ӡһ��  
 * @author Ja0ck5
 *
 */
public class Solution2 {
	
	public static void printMatrixInCircle(int[][] array){  
        if(array == null)  
            return;  
        int start = 0;
        // ��  :array[0].length         �У� array.length
        //��ֹ�кű���ʼ�к����ٴ�2��ͬʱ��ֹ�кŴ�����ʼ�к�
        while(array[0].length > start*2 && array.length >start*2){  
            printOneCircle(array,start);  
            start++;  
        }  
    }  
    private static void printOneCircle(int[][] array,int start){  
        int columns = array[0].length;  
        int rows = array.length;  
        int endX = columns - 1 - start;  
        int endY = rows - 1 - start;  
        //�����Ҵ�ӡһ��  
        for(int i = start;i <= endX ;i++){  
            int number = array[start][i];  
            System.out.print(number+",");  
        }  
        //���ϵ��´�ӡһ��  
        if(start <endY){  
            for(int i = start +1;i<=endY;i++){  
                int number = array[i][endX];  
                System.out.print(number+",");  
            }  
        }  
        //���ҵ����ӡһ��  
        if(start < endX && start < endY){  
            for(int i = endX -1;i>=start;i--){  
                int number = array[endY][i];  
                System.out.print(number+",");  
            }  
        }  
        //���µ��ϴ�ӡһ��  
        if(start <endY && start <endY -1){  
            for(int i =endY -1;i>=start+1;i--){  
                int number = array[i][start];  
                System.out.print(number+",");  
            }  
        }  
    }  
    public static void main(String[]args){  
        int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12}};  
        printMatrixInCircle(arr);  
    }  

}
