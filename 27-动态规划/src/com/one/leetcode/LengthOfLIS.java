package com.one.leetcode;

import java.util.Arrays;

/**
 * @description: 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7]的子序列
 * @author: wanjunjie
 * @date: 2025/01/20
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        // 1. 定义状态含义: dp(i) 表示以第 i 个元素结尾的 最长递增子序列
        int[] dp = new int[nums.length];
        // 2. 设置状态初始化值
        // 所有的值初始化为1
        Arrays.fill(dp, 1);
        // 3. 确定状态转移方程
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
