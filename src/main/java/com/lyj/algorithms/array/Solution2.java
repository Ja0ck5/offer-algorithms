package com.lyj.algorithms.array;

/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * { 1, 2, 3, 4}
 * { 5, 6, 7, 8}
 * { 9,10,11,12}
 * {13,14,15,16}
 * 
 * 1,左到右打印一行  
 * 2,上到下打印一行  
 * 3,右到左打印一行  
 * 4,下到上打印一行  
 * @author Ja0ck5
 *
 */
public class Solution2 {
	
	public static void printMatrixInCircle(int[][] array){  
        if(array == null)  
            return;  
        int start = 0;
        // 列  :array[0].length         行： array.length
        //终止行号比起始行号至少大2，同时终止列号大于起始列号
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
        //从左到右打印一行  
        for(int i = start;i <= endX ;i++){  
            int number = array[start][i];  
            System.out.print(number+",");  
        }  
        //从上到下打印一列  
        if(start <endY){  
            for(int i = start +1;i<=endY;i++){  
                int number = array[i][endX];  
                System.out.print(number+",");  
            }  
        }  
        //从右到左打印一行  
        if(start < endX && start < endY){  
            for(int i = endX -1;i>=start;i--){  
                int number = array[endY][i];  
                System.out.print(number+",");  
            }  
        }  
        //从下到上打印一列  
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
