package com.cc.study.jdk;

import java.util.*;

/**
 * @Date: 2020/05/21 16:18
 */
public class Test {

    public static void main(String[] args) {
        Solution solution = new Test().new Solution();
        Integer[] array = {3,9,20,null,null,15,7};
        TreeNode treeNode = TreeNode.flatToTree(new ArrayList<>(Arrays.asList(array)));
        boolean palindrome = solution.isPalindrome("A man, a plan, a canal: Panama");
    }

    class Solution {
        public boolean isPalindrome(String s) {
            if(s==null||s.length()==0) return true;
            int length = s.length();
            int start = 0;
            int end = length-1;
            while(end>start){
                if(!isValid(s.charAt(start))) {start++; continue;}
                if(!isValid(s.charAt(end))) {end--;continue;}
                char startCh = s.charAt(start);
                char endCh = s.charAt(end);
                if(startCh>='a') startCh-=32;
                if(endCh>='a') endCh-=32;
                if(startCh==endCh) {
                    start++;end--;
                }else {
                    return false;
                }
            }
            return true;
        }

        public boolean isValid(Character ch){
            if(ch>='0'&&ch<='9'
                    ||ch>='a'&&ch<='z'
                    ||ch>='A'&&ch<='Z'){
                return true;
            }
            return false;
        }
    }

}

