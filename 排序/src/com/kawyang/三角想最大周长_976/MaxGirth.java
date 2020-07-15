package com.kawyang.三角想最大周长_976;

import jdk.jshell.SourceCodeAnalysis;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * @author LiYang
 * @Project Name: LeeCode
 * @Package Name: com.kawyang.三角想最大周长_976
 * Created by MacBook Air on 2020/07/13.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class MaxGirth {
    @Test
    public void test(){
        test1();
    }

    public int test1(){
        Integer [] A1 = new Integer[]{1,2,3,4,5,6,7};

        Arrays.sort(A1, (Integer o1, Integer o2)-> o2-o1);
        System.out.println(Arrays.toString(A1));
        for (int i = 0; i < A1.length; i++) {
            for (int j = i+1; j < A1.length; j++) {
                for (int k = j+1; k< A1.length; k++){
                    if(A1[i]> A1[j]+ A1[k]){
                        return A1[i]+ A1[j]+ A1[k];
                    }
                }
            }
        }
        return 0;
    }

    @Test
    public void test2(){
        int sum = 0;
        int []A = new int[]{2,1,2};
        for (int j = 0; j < A.length; j++) {
            for (int i = 0; i < A.length-j; i++) {
                if (i+1< A.length && A[i] > A[i+1]){
                    swap(A,i,i+1);
                }
            }
            System.out.println("--- "+Arrays.toString(A)+"  ---");
            if(j >= 2){
                if(A[A.length - (j-2) -1] < A[A.length -2 -(j-2)] + A[A.length -3-(j-2)]){
                    System.out.println(A[A.length -1 -(j-2)] +"<"+ A[A.length -2 -(j-2)] +"+"+ A[A.length -3-(j-2)]);
                    sum =  A[A.length -(j-2)] + A[A.length -1 -(j-2)] + A[A.length -2-(j-2)];
                    break;
                }
            }
        }
        Assert.assertEquals(sum ,0);

    }

    private void swap(int []nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

