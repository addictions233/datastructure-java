package com.one.dynamicprogramming;

/**
 * @author one
 * @description 最长公共子串
 * @date 2025-2-7
 */
public class LCSubstring {

    public static void main(String[] args) {
        String str1 = "ABCBA";
        String str2 = "BABCA";
        System.out.println(lcSubstring(str1, str2));
    }

    static int lcSubstring(String str1, String str2) {
        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();

        // 1.定义状态含义： dp[i][j]表示以array1[i-1]和array2[j-1]结尾的最长公共子串的长度
        int[][] dp = new int[array1.length + 1][array2.length + 1];
        int max = 0;
        for (int i = 1; i <= array1.length; i++) {
            for (int j = 1; j <= array2.length; j++) {
                if (array1[i-1] == array2[j-1]) {
                    // 2.状态转移方程： 如果array1[i-1]和array2[j-1]相等, 则dp[i][j] = dp[i-1][j-1] + 1, 否则dp[i][j] = 0
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
