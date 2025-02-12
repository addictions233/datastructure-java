package com.one.dynamicprogramming;

/**
 * @author one
 * @description 最长公共子序列的长度
 * @date 2025-2-8
 */
public class LCSequence {

    static int lcSubstring(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        // 1. 定义状态含义
        // dp[i][j]表示以 text1中前i个元素 和 text2中前j个元素 的最长公共子序列得出长度
        int[][] dp = new int[arr1.length+1][arr2.length+1];

        // 2. 设置状态初始化值

        // 3. 确定状态转移方程
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
