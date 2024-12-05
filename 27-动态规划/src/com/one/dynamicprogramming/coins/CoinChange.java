package com.one.dynamicprogramming.coins;

/**
 * @author one
 * @description Leetcode 322 零钱兑换
 * @date 2024-12-5
 */
public class CoinChange {

    public int coins(int n) {
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

    public int coinChange(int[] coins, int amount) {
        return 0;
    }
}
