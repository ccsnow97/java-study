package com.cc.study.jdk;

import java.util.*;

/**
 * @Date: 2020/05/21 16:18
 */
public class Test {

    public static void main(String[] args) {
        Solution solution = new Test().new Solution();
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeNode.flatToTree(new ArrayList<>(Arrays.asList(array)));
        int[] test = {5, 7, 7, 8, 8, 10};
        char s = ' ';
        String s1 = Integer.toBinaryString(s);
        long start = System.currentTimeMillis();
        int i = solution.superEggDrop(3, 14);
        double time = (System.currentTimeMillis() - start) / 1000.0;
    }

    class Solution {
        public int superEggDrop(int K, int N) {
            int[][] p = new int[K + 1][N + 1];
            for (int n = 1; n <= N; n++) p[1][n] = n;
            for (int k = 2; k <= K; k++) {
                for (int n = 1; n <= N; n++) {
                    int res = Integer.MAX_VALUE;
                    int start = 1, end = n, mid;
                    /*  这是遍历
                    for (int i = 1; i <= n; i++) {
                        res = Math.min(res, Math.max(p[k - 1][i - 1], p[k][n - i]) + 1);
                    }
                    */
                    //这是二分
                    while (start <= end) {
                        mid = start + (end - start) / 2;
                        if (p[k - 1][mid - 1] == p[k][n - mid]) {
                            res = p[k - 1][mid - 1] + 1;
                            break;
                        } else if (p[k - 1][mid - 1] > p[k][n - mid]) {
                            end = mid - 1;
                            res = Math.min(res, p[k - 1][mid - 1] + 1);
                        } else if (p[k - 1][mid - 1] < p[k][n - mid]) {
                            start = mid + 1;
                            res = Math.min(res, p[k][n - mid] + 1);
                        }
                    }
                    p[k][n] = res;
                }
            }
            return p[K][N];
        }

    }

}