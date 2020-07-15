package com.kawyang.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author LiYang
 * @Project Name: LeeCode
 * @Package Name: com.kawyang.test
 * Created by MacBook Air on 2020/07/13.
 * Copyright © 2020 LiYang. All rights reserved.
 */


public class test {
    public static int[] arr = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i+ "input:");
            arr[i] = sc.nextInt();

        }
        //调用方法进行快速排序
        quickSort(0, arr.length - 1);

        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void quickSort(int n, int m) {
        if (n < m) {//因为m的下标是右边的，那么必然是大于n的，就说明不只一个元素，此时进行交换
            //定义基准的下标
            int index = (m + n) / 2;
            int pivot = arr[index];//将中间的数作为基准，并将其值赋给临时变量pivot
            int m2 = m, n2 = n;
            int partition = getPartition(n,m,pivot);//分割，其中返回的值是分割的值的下标
            //利用递归，将左右两个子数组进行排序
            quickSort(n2, partition-1);//左子数组
            quickSort(partition+1, m2);//右子数组
        }else{
            //如果n等于m，就说明了只有一个元素，若大于m，那么范围不对（就好比区间[2,3],那么2肯定是比3小的，所以左边的一定比右边的小）
            return;
        }
    }
    public static int getPartition(int n, int m, int pivot){
        //将数组分成两个子数组，其中左子数组的值小于中间枢纽pivot的值，而右子数组的值大于中间枢纽的值
        while (true) {
            //当n>=m,说明了左边都是小于标注的值，这时候就可以退出循环
            while (n<m && arr[n] < pivot) {
                //需要在n<m的前提下进行判断，如果左边是小于标准的值，那么就右移,直到找到第一个大于标准的值的下标
                //注意这里需要有n<m,否则有可能n一直移到最右边，那么很容易发生溢出，从而会报错
                n++;
            }
            while (n<m && arr[m] >= pivot) {
                //需要在n<m的前提下进行判断，如果右边找到了第一个小于标准的值，那么就退出循环，否则往左移
                //注意这里需要有n<m，否则有可能m一直移到最左边，那么很容易发生溢出，从而会报错
                m--;
            }
            if (n >= m) {
                //相遇了，那么就退出循环，说明基准的左边都是小于基准的数，右边都是大于基准的数，此时基准的下标为n或m，而不是原来的index
                break;
            } else {
                swap(n,m);
            }
        }
        return n;//返回基准的下标
    }
    public static void swap(int n , int m){
        //没有相遇，将二者进行交换
        int temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;


    }
}