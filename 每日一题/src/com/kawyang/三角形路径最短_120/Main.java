package com.kawyang.三角形路径最短_120;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * @author LiYang
 * @Project Name: LeeCode
 * @Package Name: com.kawyang.三角形路径最短_120
 * Created by MacBook Air on 2020/07/14.
 * Copyright © 2020 LiYang. All rights reserved.
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] ints = new int[(1 + size) * size / 2];
        int i = 0;
        for (List<Integer> list: triangle){
             for (Integer in :
                     list) {
                 ints[i++] = in;
             }
        }
        return -1;
    }
}

/**
 * @author LiYang
 */
public class Main{
    public static void main(String[] args){
        System.out.println(3%0);
    }
}