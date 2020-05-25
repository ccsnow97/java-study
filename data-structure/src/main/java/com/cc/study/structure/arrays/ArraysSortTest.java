package com.cc.study.structure.arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * @Date: 2020/05/22 17:29
 */
public class ArraysSortTest {

    static int[] generateArrayInt(int length){
        int[] ints = new int[length];
        Random random = new Random();
        for(int i=0;i<length;i++){
            ints[i]= random.nextInt();
        }
        return ints;
    }

    static int[] copyIntArray(int[] array){
        return Arrays.copyOf(array,array.length);
    }

    static long sort(int[] array){
        long start = System.currentTimeMillis();
        Arrays.sort(array);
        return System.currentTimeMillis()-start;
    }

    static long parallelSort(int[] array){
        long start = System.currentTimeMillis();
        Arrays.parallelSort(array);
        return System.currentTimeMillis()-start;
    }

    public static void main(String[] args) {
        int tenShousand = 10000;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessors);
        int[] scales = new int[]{tenShousand,10*tenShousand,11*tenShousand,12*tenShousand};
        for(int i=0;i<scales.length;i++){
            int[] arrayInt = generateArrayInt(scales[i]);
            int[] copyIntArray = copyIntArray(arrayInt);
            System.out.print("scale:"+scales[i]);
            System.out.print(" sort:"+sort(arrayInt));
            System.out.println(" parallel:"+parallelSort(copyIntArray));
        }
        System.out.println("end");
    }

}
