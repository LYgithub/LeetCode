package com.kawyang.test;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author LiYang
 * @Project Name: LeeCode
 * @Package Name: com.kawyang.test
 * Created by MacBook Air on 2020/07/13.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class PriorityQueueTest {

    @Test
    public void test1(){
        PriorityQueue <Integer > priorityQueue = new PriorityQueue<>(30);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            priorityQueue.add(random.nextInt(100));
        }
        System.out.println(priorityQueue.size());
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    @Test
    public void test2(){
        // 找出 k 个最大的值
        int[] ints = new int[]{1,2,32,4,5,5,1,33,22,21,2,1,21};
        int k = 5;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < ints.length; i++) {
            priorityQueue.add(ints[i]);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        for (int i = 0,sum = priorityQueue.size(); i < sum; i++) {
            System.out.println(priorityQueue.poll());
        }
    }
}
