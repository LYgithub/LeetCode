package com.kawyang.第K大值;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.plaf.nimbus.State;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author LiYang
 * @Project Name: LeeCode
 * @Package Name: com.kawyang.第K大值
 * Created by MacBook Air on 2020/07/13.
 * Copyright © 2020 LiYang. All rights reserved.
 */

public class KthElementTest {
    int[] ints = new int[]{1,2,32,4,5,5,1,33,22,2,2,10,21};
    int k = 5;

    @Test
    public void main(){
        System.out.println(sortFindKth(ints,k));
        Assert.assertEquals(sortFindKth(ints,k),PriorityQueueFindKth(ints,k));
    }
    /**
     * 排序查找 时间复杂度 O(NlogN)
     * @param nums
     * @param k
     * @return
     */
    public int sortFindKth(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 堆排序  O(NlogK)
     * @param nums
     * @param k
     * @return
     */
    public int PriorityQueueFindKth(int [] nums, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Integer i : nums) {
            queue.add(i);
            if(queue.size() > k){
                queue.poll();
            }
        }
        // 返回顶部元素
        return queue.peek();
    }

    /**
     * 快排  O(N)
     * @param nums
     * @param k
     * @return
     */
    public int QuickSort(int [] nums, int k){
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    //
    private int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) {}
            while (a[--j] > a[l] && j > l) {}
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    @Test
    public void findKthLargest() {
        int []nums = new int[]{3,2,1,5,6,4};
        int k = 1;
        if( k > nums.length || k <= 0) {
            return;
        }
        for(int i = 0; i<nums.length; i++){
            for(int j = 0; j<nums.length-i; j++){
                if(j+1<nums.length && nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
            if(i+1 == k){
                break;

            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(nums[nums.length - k]);
    }

    /**
     * 查找 ，快排查找
     * 快排将 所有值 划分为 大于 pivot 和 小于 pivot 的部分。
     * 当 pivot_index 刚好等于 k 时 返回。
     */
    class Solution {

        public void swap(int a, int b, int[] nums) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }

        public int partition(int left, int right, int pivot_index, int[] nums) {
            int pivot = nums[pivot_index];
            // 1. move pivot to end
            swap(pivot_index, right, nums);
            int store_index = left;

            // 2. move all smaller elements to the left
            for (int i = left; i <= right; i++) {
                if (nums[i] > pivot) {
                    swap(store_index, i, nums);
                    store_index++;
                }
            }

            // 3. move pivot to its final place
            swap(store_index, right, nums);

            return store_index;
        }

        public int quickselect(int left, int right, int k_smallest, int[] nums) {
            /*
            Returns the k-th smallest element of list within left..right.
            */

            if (left == right) // If the list contains only one element,
                return nums[left];  // return that element

            // select a random pivot_index
            Random random_num = new Random();
            int pivot_index = left + random_num.nextInt(right - left + 1);

            pivot_index = partition(left, right, pivot_index, nums);

            // the pivot is on (N - k)th smallest position
            if (k_smallest-1 == pivot_index)
                return nums[pivot_index];
                // go left side
            else if (k_smallest-1 < pivot_index)
                return quickselect(left, pivot_index - 1, k_smallest, nums);
            // go right side
            return quickselect(pivot_index + 1, right, k_smallest, nums);
        }

        public int findKthLargest(int[] nums, int k) {
            int size = nums.length;
            // kth largest is (N - k)th smallest
            return quickselect(0, size - 1, k, nums);
        }
    }

    @Test
    public void test2(){
        int k =1;
        int [] nums ;
        for(int i = 1; i< 7; i++){
            nums = new int[]{3,2,1,5,6,4};
            k = i;
            QuickSort_findKth(nums, 0, nums.length-1,k);
            System.out.println("Arrays:"+Arrays.toString(nums));
            System.out.println(i + ":" + nums[nums.length - k]);
        }
    }

    public void QuickSort_findKth(int [] nums, int start, int end, int k){
        int l = start,r = end;
        if(start < end){
            int pivot = nums[l];
            while (true){
                while (l<end && nums[l] < pivot){ l++; }
                while (r > start && nums[r] > pivot){ r--;}
                if( l >= r)
                    break;
                swap(nums,l,r);
            }
            System.out.println(Arrays.toString(nums));
        }

        if( l == nums.length - k){
            return;
        }else if( l < nums.length - k){
            QuickSort_findKth(nums,l+1,end,k);
        }else {
            QuickSort_findKth(nums,start,l-1,k);
        }
    }
}
