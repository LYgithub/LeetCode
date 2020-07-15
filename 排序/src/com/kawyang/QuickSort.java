package com.kawyang;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author LiYang
 * @Project Name: LeeCode
 * @Package Name: com.kawyang
 * Created by MacBook Air on 2020/07/13.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class QuickSort {
    @Test
    public void test(){
        int [] nums = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            nums[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(nums));
        sort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 快速排序
     * @param nums
     * @param start
     * @param end
     */
    public void sort(int [] nums, int start ,int end){
        if(start >= end){
            return;
        }
        int l = start,r = end;
        int privot = nums[l];

        while (true){
            while (nums[r] > privot && r > start){ r--;}
            while (nums[l] < privot && l < end){ l++;}
            if(l >= r){
                break;
            }
            swap(nums, l,r);
        }
        sort(nums,start, l-1);
        sort(nums,l+1, end);
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
