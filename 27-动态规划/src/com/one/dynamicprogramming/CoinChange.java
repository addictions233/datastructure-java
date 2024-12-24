package com.one.dynamicprogramming;

import java.util.concurrent.CompletionService;

/**
 * @author one
 * @description Leetcode 322 零钱兑换
 * @date 2024-12-5
 */
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coins(41));
        System.out.println(coins2(41));
        System.out.println(coins3(41));
    }

    /**
     * 暴力解法
     * @param n 兑换金额为n的最少硬币个数
     * @return 硬币个数
     */
    public static int coins(int n) {
        if (n < 1) {
            return Integer.MAX_VALUE;
        }
        if (n == 25 || n == 20 || n == 5 || n == 1) {
            return 1;
        }
        int min1 = Math.min(coins(n - 25),  coins(n - 20));
        int min2 = Math.min(coins(n - 5),  coins(n - 1));
        return Math.min(min1, min2) + 1;
    }

    /**
     * 记忆化搜索 (自顶而下的递归调用)
     * @param n 兑换金额为n的最少硬币个数
     * @return 硬币个数
     */
    public static int coins2(int n) {
        if (n < 1) {
            return -1;
        }
        int[] dp = new int[n + 1];
        int[] faces = {1,5,20,25};
        for (int i = 0; i < faces.length; i++) {
            if (n < faces[i]) {
                break;
            }
            dp[faces[i]] = 1;
        }
        return coins2(n, dp);
    }

    static int coins2(int n, int[] dp) {
        if (n < 1) {
            return Integer.MAX_VALUE;
        }
        if (dp[n] == 0) {
            int min1 = Math.min(coins2(n -25, dp), coins2(n - 20, dp));
            int min2 = Math.min(coins2(n -5,dp), coins2(n-1,dp));
            dp[n] = Math.min(min1, min2) + 1;
        }
        return dp[n];
    }


    /**
     * 递推 (自底而上的迭代)
     * @param n 兑换金额为n的最少硬币个数
     * @return 硬币个数
     */
    static int coins3(int n) {
        if (n < 1) {
            return -1;
        }
        // dp[0] = 0;
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i >= 1) {
                min = Math.min(dp[i-1], min);
            }
            if (i >= 5) {
                min = Math.min(dp[i-5], min);
            }
            if (i >= 20) {
                min = Math.min(dp[i-20], min);
            }
            if (i >= 25) {
                min = Math.min(dp[i-25], min);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }




}
