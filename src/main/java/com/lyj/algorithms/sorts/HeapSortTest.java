package com.lyj.algorithms.sorts;
public class HeapSortTest {  
  
    public static void main(String[] args) {  
        int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };  
        print(data5);  
        heapSort(data5);  
        System.out.println("���������飺");  
        print(data5);  
    }  
  
    public static void swap(int[] data, int i, int j) {  
        if (i == j)
            return;  
        //1 ����    
//        data[i] = data[i] + data[j];  
//        data[j] = data[i] - data[j];  
//        data[i] = data[i] - data[j];  
        //2 ����
        data[i] ^= data[j];
        data[j] ^= data[i];
        data[i] ^= data[j];
    }  
  
    public static void heapSort(int[] data) {  
        for (int i = 0; i < data.length; i++) {  
        	//�����󶥶�,�ȽϺ�����ֵ�����ٴι����󶥶ѡ�ֻ�������µ���ֵ���й����󶥶�
            createMaxdHeap(data, data.length - 1 - i);  
            //�����ֵ�����һ������
            swap(data, 0, data.length - 1 - i);  
            print(data);  
        }  
    }  
  
    public static void createMaxdHeap(int[] data, int lastIndex) {  
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {  
            // ���浱ǰ�����жϵĽڵ�  
            int k = i;  
            // ����ǰ�ڵ���ӽڵ����  
            while (2 * k + 1 <= lastIndex) {  
               
            	// biggerIndex���Ǽ�¼�ϴ�ڵ��ֵ,�ȸ�ֵΪ��ǰ�жϽڵ�����ӽڵ�  
                int biggerIndex = 2 * k + 1;  
                if (biggerIndex < lastIndex) {  
                    // �Ƚ������ӽڵ�  
                    if (data[biggerIndex] < data[biggerIndex + 1])  
                        // �����ӽڵ�ֵ�����ӽڵ�ֵ����biggerIndex��¼�������ӽڵ��ֵ  
                        biggerIndex++;  
                } 
                
                //�����ӽڵ��뵱ǰ�ڵ�Ƚ�
                if (data[k] < data[biggerIndex]) {  
                    // ����ǰ�ڵ�ֵ���ӽڵ����ֵС���򽻻�2�ߵ�ֵ
                    swap(data, k, biggerIndex);  
                    //������biggerIndexֵ��ֵ��k,�������� 2k+1 λ��Ϊ�����ӽڵ�  
                    k = biggerIndex;  
                } else {  
                    break;  
                }
                
            }  
        }  
    }  
  
    public static void print(int[] data) {  
        for (int i = 0; i < data.length; i++) {  
            System.out.print(data[i] + "\t");  
        }  
        System.out.println();  
    }  
  
}  
