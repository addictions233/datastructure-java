package com.one.leetcode;

/**
 * @description: 2140. 解决智力问题
 * 给你一个下标从 0 开始的二维整数数组 questions ，其中 questions[i] = [pointsi, brainpoweri] 。
 * 这个数组表示一场考试里的一系列题目，你需要 按顺序 （也就是从问题 0 开始依次解决），针对每个问题选择 解决 或者 跳过 操作。
 * 解决问题 i 将让你 获得  pointsi 的分数，但是你将 无法 解决接下来的 brainpoweri 个问题（即只能跳过接下来的 brainpoweri 个问题）。
 * 如果你跳过问题 i ，你可以对下一个问题决定使用哪种操作。
 * 比方说，给你 questions = [[3, 2], [4, 3], [4, 4], [2, 5]] ：
 * 如果问题 0 被解决了， 那么你可以获得 3 分，但你不能解决问题 1 和 2 。
 * 如果你跳过问题 0 ，且解决问题 1 ，你将获得 4 分但是不能解决问题 2 和 3 。
 * 请你返回这场考试里你能获得的 最高 分数。
 * @author: wanjunjie
 * @date: 2025/01/20
 */
public class MostPoints {

    /**
     * 正向思考: dp[i] 表示选择以i 结尾的元素, 所能达到的最大和
     * 无后效性: 某个阶段的状态一旦确定, 则此后过程的决策不再受此前各种状态及决策的影响
     * 有后效性: 就是某个状态之后要做的决策会受到之前的状态和决策的影响
     * 无后效性是动态规划和贪心算法的前提条件
     * @param questions
     * @return
     */
    public long mostPoints(int[][] questions) {
        // 1. 定义状态含义: 最后一个选择int[i] 所能获取的最大分数, 对于区间 [0, i]
        long[] dp = new long[questions.length];
        // 2. 定义状态初始化值, dp[0] 选择第一个元素的值
        dp[0] = questions[0][0];
        long max = dp[0];
        // 时间复杂度 O(n^2), 会超时, 需要实现O(n)时间复杂度的解法
        for (int i = 1; i < dp.length; i++) {
            dp[i] = questions[i][0];
            for (int j = 0; j < i; j++) {
                // 3. 定义状态转移方程: 如果 j + questions[j][1] < i 说明可以加上 dp[j]
                if (questions[j][1] + j < i) {
                    dp[i] = Math.max(dp[i], dp[j] + questions[i][0]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    /**
     * 反向思考: dp[i] 表示 在[i, n] 之前所能选择的元素的最大和
     * 第 i 个元素的选择与否不影响 小于 i 的元素是否可以选择, 只满足无后效性
     * @param questions
     * @return
     */
    public long mostPoints2(int[][] questions) {
        // 1. 定义状态含义: dp[i] 表示 对于区间 [i, n -1] 区间所能选择的最大值
        long[] dp = new long[questions.length + 1];

        // 2. 设置状态初始化值, dp[questions.length] = 0
        for (int i = questions.length - 1; i >= 0; i--) {
            // 3, 定义状态转移方程,
            // 如果选择第 i 个元素,  dp[i] = questions[i][0] + dp[i + questions[i][1] + 1]
            // 如果不选择第 i 个元素, dp[i] = dp[i+1]
            int j = i + questions[i][1] + 1;
            dp[i] = Math.max(dp[i+1], j < questions.length ? dp[j] + questions[i][0] : questions[i][0]);
        }
        return dp[0];
    }
}
