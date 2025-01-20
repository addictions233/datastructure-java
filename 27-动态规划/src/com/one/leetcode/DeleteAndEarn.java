package com.one.leetcode;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @description: 740. 删除并获得点数
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * @author: wanjunjie
 * @date: 2025/01/15
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.compute(num, (key, value) -> {
                if (Objects.isNull(value)) {
                    return num;
                } else {
                    return value + num;
                }
            });
        }
        int[] dp = new int[map.size() + 1];
        int i = 1;
        int lastKey = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (i == 1) {
                dp[i] = entry.getValue();
                i++;
                lastKey = entry.getKey();
                continue;
            }
            if (lastKey  + 1 == entry.getKey()) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + entry.getValue());
            } else {
                dp[i] = dp[i-1] + entry.getValue();
            }
            i++;
            lastKey = entry.getKey();
        }
        return dp[map.size()];
    }
}
