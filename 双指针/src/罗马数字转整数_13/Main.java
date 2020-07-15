package 罗马数字转整数_13;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiYang
 * @Project Name: LeeCode
 * @Package Name: 罗马数字转整数_13
 * Created by MacBook Air on 2020/07/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Main {
    @Test
    public void test(){
        Solution solution = new Solution();
        Assert.assertEquals(solution.romanToInt("IIV"),5);
        Assert.assertEquals(solution.romanToInt("VII"),7);
    }
}
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum = 0,a;
        for(int i = 0;i<s.length(); i++){
            a = map.get(s.charAt(i));
            if(i+1 < s.length() && a<map.get(s.charAt(i+1))){
                sum -= a;
            }else {
                sum += a;
            }
        }
        return sum;
    }
}