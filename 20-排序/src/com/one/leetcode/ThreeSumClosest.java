package com.one.leetcode;

import java.util.Arrays;
import java.util.Map;

/**
 * @description: 16. 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * @author: wanjunjie
 * @date: 2025/02/25
 */
public class ThreeSumClosest {
    /**
     * 使用排序和双子针
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = start + nums[left] + nums[right];
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
                if (Math.abs(result - target) > Math.abs(sum - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
