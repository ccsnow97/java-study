package com.cc.study.structure.algorithm.sort;

import java.util.Random;

/**
 * @Date: 2020/07/14 17:01
 */
public class SortUtils {

    public static void main(String[] args) {
        int length = 100;
        int[] arrays = new int[length];
        Random random = new Random();
        for(int i=0;i<length;i++){
            arrays[i]=random.nextInt(3000);
        }
        System.out.print("排序前：");
        print(arrays);
        System.out.print("排序后：");
        quickSort(arrays);
        print(arrays);
    }

    /**
     * 快速排序
     * @param arrays
     */
    public static void quickSort(int[] arrays){
        quickSort(arrays,0,arrays.length-1);
    }

    private static void quickSort(int[] arrays,int start,int end){
        if(start>=end) return;
        int base = arrays[start];
        int left = start;
        int right = end;
        while (left<right){
            while(left<right&&arrays[right]>=base){
                right--;
            }
            while(arrays[left]<=base&&left<right) {
                left++;
            }
            if(left<right){
                swap(arrays,left,right);
                right--;
            }
        }
        if(right!=start){
            swap(arrays,start,right);
        }
        quickSort(arrays,start,right-1);
        quickSort(arrays,right+1,end);
    }

    private static void swap(int[] arrays,int left,int right){
        int temp = arrays[right];
        arrays[right]=arrays[left];
        arrays[left]=temp;
    }

    private static void print(int[] arrays){
        System.out.print("{ ");
        for(int e:arrays){
            System.out.print(e+" ");
        }
        System.out.println("}");
    }
}
