package com.one.leetcode;

import org.junit.Test;

/**
 * @author one
 * @description 516. 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * @date 2025-1-27
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        // 1. 定义状态含义： dp[i][j] 表示 s[i..j] 中最长回文子序列的长度
        int[][] dp = new int[n][n];
        // 2, 初始化状态：当字符串长度为1时，最长回文子序列长度为1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // 3, 状态转移方程：
        for (int len = 1; len < n; len++) {
            for (int i = 0; i+len < n; i++) {
                if (charArray[i] == charArray[i+len]) {
                    dp[i][i+len] = dp[i+1][i+len-1] + 2;
                } else {
                    dp[i][i+len] = Math.max(dp[i][i+len-1], dp[i+1][i+len]);
                }
            }
        }
        return dp[0][n-1];
    }

    @Test
    public void test() {
        String str = "bbbab";
        int result = longestPalindromeSubseq(str);
        System.out.println(result);
    }
}
