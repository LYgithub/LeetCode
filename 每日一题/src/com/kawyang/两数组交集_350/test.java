package com.kawyang.两数组交集_350;

import org.junit.Test;


import java.util.*;

/**
 * @author LiYang
 * @Project Name: LeeCode
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/07/13.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class test {

    public static void main(String[] args) {
        int [] nums1 = new int[]{4,9,5,4};
        int [] nums2 = new int[]{3,9,2,9,4,3,4 };

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }else {
                map.put(nums1[i], 1);
            }
        }
        System.out.println(map.values());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i]) && map.get(nums2[i])>0){
                map.put(nums2[i], map.get(nums2[i])-1);
                list.add(nums2[i]);
            }
        }
        System.out.println(map.values());
        int [] n = new int[list.size()];
        for (int i = 0; i < n.length; i++) {
            n[i] = list.get(i);
        }
        System.out.println(Arrays.toString(n));
    }

    @Test
    public int[] test1(){
        int [] nums1 = new int[]{4,9,5,4};
        int [] nums2 = new int[]{3,9,2,9,4,3,4 };

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        int i=0,j=0,k=0;
        int [] n = new int[Math.min(nums1.length, nums2.length)];
        while (i<nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                n[k++] = nums1[i];
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return Arrays.copyOfRange(n, 0, k);
    }
}
