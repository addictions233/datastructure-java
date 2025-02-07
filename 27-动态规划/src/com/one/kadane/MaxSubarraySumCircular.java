package com.one.kadane;

import org.junit.Test;

/**
 * @description: 918. 环形子数组的最大和
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，
 * 不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 * @author: wanjunjie
 * @date: 2025/01/22
 */
public class MaxSubarraySumCircular {

    public int maxSubarraySumCircular(int[] nums) {
        // 求出和, 最大子数组和, 最小子数组和
        int sum = 0;
        // 最大子数组和
        int maxR = Integer.MIN_VALUE;
        // 最小子数组和
        int minR = Integer.MAX_VALUE;
        // 以nums[i]结尾的最大子数组和
        int minF = 0;
        // 以nums[i]结尾的最小子数组和
        int maxF = 0;
        for (int num : nums) {
            sum += num;
            maxF = maxF > 0 ? maxF + num : num;
            minF = minF < 0? minF + num : num;
            maxR = Math.max(maxR, maxF);
            minR = Math.min(minR, minF);
        }

        if (minR == sum) {
            return maxR;
        } else {
            return Math.max(maxR, sum - minR);
        }
    }

    @Test()
    public void test() {
        int[] nums = {-3,-2,-3};
        System.out.println(maxSubarraySumCircular(nums));
    }
}
