package com.one.leetcode;

import java.util.Arrays;
import java.util.Map;

/**
 * @description: 2500. 删除每行中的最大值
 * @author: wanjunjie
 * @date: 2025/02/20
 */
public class DeleteGreatestValue {

    public int deleteGreatestValue(int[][] grid) {
        for (int[] arr : grid) {
            Arrays.sort(arr);
        }
        int sum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int[] arr : grid) {
                max = Math.max(max, arr[i]);
            }
            sum += max;
        }
        return sum;
    }
}
