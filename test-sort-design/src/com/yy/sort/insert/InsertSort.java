package com.yy.sort.insert;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 插入算法
 *
 * @author yangy
 * @time 2018-04-16 15:59
 **/
public class InsertSort {
    private int[] array;
    private int length;

    public InsertSort(int[] array) {
        this.array = array;
        this.length = array.length;
    }

    public int[] inserSort(){
        int out ;
        int in ;
        for (out = 1; out <length ; out++) {
            in = out;
            int temp = array[out];
            while(in>0 &&array[in-1]>temp){
                array[in] = array[in -1];
                in--;
            }
            array[in]=temp;
        }
        return array;
    }
    public static void main(String[] args){
        int[] a = {1,3,2,7,4,99,20};
        InsertSort is=new InsertSort(a);
        int[] ints = is.inserSort();
        System.out.println(Arrays.toString(a));

    }

}
