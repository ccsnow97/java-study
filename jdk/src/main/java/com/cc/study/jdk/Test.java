package com.cc.study.jdk;

import java.util.*;

/**
 * @Date: 2020/05/21 16:18
 */
public class Test {

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(2,"tom");
        map.put(3,"tony");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(2,"tom");
        hashMap.put(3,"tony");
        Set<Map.Entry<Integer, String>> entries1 = hashMap.entrySet();
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp=new int[nums.length];
            dp[0]=nums[0];
            int max=dp[0];
            for(int i=1;i<nums.length;i++){
                dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
                max=Math.max(max,dp[i]);
            }
            return max;
        }
    }

}

