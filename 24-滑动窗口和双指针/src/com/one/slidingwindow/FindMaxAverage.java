package com.one.slidingwindow;

import java.sql.Array;
import java.util.Arrays;

/**
 * @description: 643. 子数组最大平均数 I
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * @author: wanjunjie
 * @date: 2024/12/13
 */
public class FindMaxAverage {

    /**
     * 对应定长为n的滑动窗口
     */
    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length <= k) {
            return 1.0 * Arrays.stream(nums).sum() / k;
        }
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 初始化窗口
            if (i < k -1) {
                sum += nums[i];
                continue;
            }
            // 进入窗口
            sum += nums[i];
            // 获取结果
            maxSum = Math.max(maxSum, sum);
            // 离开窗口
            sum -= nums[i -k + 1];
        }
        return 1.0 * sum / k;
    }

    public static void main(String[] args) {
        findMaxAverage(new int[]{-1}, 1);
    }
}
