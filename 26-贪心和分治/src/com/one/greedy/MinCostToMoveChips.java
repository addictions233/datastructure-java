package com.one.greedy;

/**
 * @description: 1217. 玩筹码
 * 有 n 个筹码。第 i 个筹码的位置是 position[i] 。
 * 我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从 position[i] 改变为:
 * position[i] + 2 或 position[i] - 2 ，此时 cost = 0
 * position[i] + 1 或 position[i] - 1 ，此时 cost = 1
 * 返回将所有筹码移动到同一位置上所需要的 最小代价 。
 * @author: wanjunjie
 * @date: 2025/01/02
 */
public class MinCostToMoveChips {
    public int minCostToMoveChips(int[] position) {
        // 奇数位置的筹码异动到奇数位置cost = 0, 移动到偶数位置 cost = 1
        // 同理 偶数位置的筹码移动到偶数位置cost =0, 移动到奇数位置 cost =1
        int first = 0;
        int second = 0;
        for (int i : position) {
            if (i % 2 == 1) {
                second++;
            } else {
                first++;
            }
        }
        return Math.min(first, second);
    }
}
