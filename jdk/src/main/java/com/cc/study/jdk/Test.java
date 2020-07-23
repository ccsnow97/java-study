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
        public int lengthOfLongestSubstring(String s) {
            if(s==null||s.length()==0) return 0;
            int[] f=new int[s.length()];
            f[0]=1;
            int res=1;
            for(int i=1;i<s.length();i++){
                int temp = 1;
                for(int j=i-1;j>=i-f[i-1];j--){
                    if(s.charAt(i)!=s.charAt(j)){
                        temp++;
                    }else {
                        break;
                    }
                }
                f[i]=temp;
                res=Math.max(res,temp);
            }

            return res;
        }
    }


}