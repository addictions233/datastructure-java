package com.one.leetcode;

import java.util.concurrent.ConcurrentMap;

/**
 * @description: 746. 使用最小花费爬楼梯
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 * @author: wanjunjie
 * @date: 2025/01/13
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        // 方法一: 暴力递归
//        return solution1(cost, cost.length);

        int[] result = new int[cost.length + 1];
        for (int i = 2; i < result.length; i++) {
            result[i] = -1;
        }
        return solution2(cost, cost.length, result);
    }

    /**
     * 使用暴力递归: 时间复杂度和空间复杂度都O(2^n), 容易超时
     */
    public int solution1(int[] cost, int n) {
        if (n <= 1) {
            return 0;
        }
        return Math.min(solution1(cost,n - 2) + cost[n-2], solution1(cost, n -1) + cost[n - 1]);
    }

    /**
     * 使用记忆化搜索: 用result数组记录中间计算结果, 防止重复计算
     */
    public int solution2(int[] cost,int n, int[] result) {
        if (result[n] != -1) {
            return result[n];
        }
        result[n] = Math.min(solution2(cost,n - 2, result) + cost[n-2], solution2(cost, n -1, result) + cost[n - 1]);
        return result[n];
    }
}
