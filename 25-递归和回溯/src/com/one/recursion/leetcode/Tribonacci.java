package com.one.recursion.leetcode;

/**
 * @description: 1137. 第 N 个泰波那契数
 * 泰波那契序列 Tn 定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * @author: wanjunjie
 * @date: 2025/01/13
 */
public class Tribonacci {

    /**
     * 暴力递归, 记忆化搜索, 递推
     */
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n==2) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i -3] + dp[i -2] + dp[i -1];
        }
        return dp[n];
    }
}
