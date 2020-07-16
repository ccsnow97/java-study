package com.cc.study.jdk;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Date: 2020/05/21 16:18
 */
public class Test {

    public static void main(String[] args) {
        Solution solution = new Test().new Solution();
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeNode.flatToTree(new ArrayList<>(Arrays.asList(array)));
        int[] coins = {1, 2, 5};
        char s = ' ';
        String s1 = Integer.toBinaryString(s);
        long start = System.currentTimeMillis();
        String str="73A98988-8928-40D0-A3B4-70147E8B895A";
        int length = str.length();
        double time = (System.currentTimeMillis() - start) / 1000.0;
    }

    class Solution {
        public int largestRectangleArea(int[] heights) {
            return 0;
        }
    }


}