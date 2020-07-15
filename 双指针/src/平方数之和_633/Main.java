package 平方数之和_633;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author LiYang
 * @Project Name: LeeCode
 * @Package Name: 平方数之和_633
 * Created by MacBook Air on 2020/07/11.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
    @Test
    public void test(){
        for(int i = 0; i< 100; i++){
            System.out.println(i);
            try {

                Assert.assertEquals(Solution2.judgeSquareSum(i),Solution.judgeSquareSum(i));
            }catch (Exception e){
                System.out.println("Error:" + i);
            }
        }
    }
}
class Solution {
    public static boolean judgeSquareSum(int c) {
        int index1 = 0;
        int index2 = (int) Math.sqrt(c*1.0);
        double sum;
        boolean tag = false;
        while (index1 <= index2){
            sum = Math.pow(index1, 2) + Math.pow(index2, 2);
            if(sum == c){
                tag = true;
                break;
            }
            else if(sum > c){
                index2--;
            }else if(sum < c){
                index1++ ;
            }
        }
        return tag;
    }
}

class Solution2 {
    public static boolean judgeSquareSum(int c) {
        int i = 0;
        double sub;
        boolean tag = false;
        int j =(int) Math.sqrt(c*1.0) + 1;
        while(i < j){
            sub = c - i * i;
            if(sub == (int)sub){
                if((int)Math.sqrt(sub) == Math.sqrt(sub)){
                    tag = true;
                    break;
                }
            }
            i++;
        }
        return tag;
    }
}

class Solution3 {
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            // c 是 i 的倍数
            if (c % i == 0) {
                //
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0) {
                    return false;
                }
            }
        }
        return c % 4 != 3;
    }
}
