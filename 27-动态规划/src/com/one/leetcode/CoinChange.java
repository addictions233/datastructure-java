package com.one.leetcode;

/**
 * @description: 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * @author: wanjunjie
 * @date: 2025/01/13
 */
public class CoinChange {

    /**
     * 动态规划: 递推
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1) {
                    min = Math.min(min, dp[i - coin]);
                }
            }
            if (min == Integer.MAX_VALUE) {
                // 如果没有任何一种硬币组合能组成总金额，返回 -1
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }

        }
        return dp[amount];
    }
}
