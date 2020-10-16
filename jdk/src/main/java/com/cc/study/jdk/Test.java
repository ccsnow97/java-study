package com.cc.study.jdk;

import java.util.Arrays;
import java.util.List;

/**
 * @Date: 2020/05/21 16:18
 */
public class Test {

    public static void main(String[] args) {
        Solution solution = new Test().new Solution();

    }

    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int min = 0;
            if (triangle.size() == 0) return min;
            Integer lastRowLength = triangle.get(triangle.size() - 1).size();
            int f[] = new int[lastRowLength];
            for (List<Integer> row : triangle) {
                if (row.size() == 1) f[0] = row.get(0);
                else {
                    for (int i = row.size() - 1; i >= 0; i--) {
                        if (i == row.size() - 1) {
                            f[i] = f[i - 1] + row.get(i);
                        } else if (i == 0) {
                            f[i] = f[i] + row.get(i);
                        } else {
                            f[i] = Math.min(f[i], f[i - 1]) + row.get(i);
                        }
                    }
                }
            }

            min = Arrays.stream(f).min().orElse(0);

            return min;
        }
    }


}