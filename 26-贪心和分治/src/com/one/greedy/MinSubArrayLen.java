package com.one.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的子数组
 *  [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * @author: wanjunjie
 * @date: 2025/01/03
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum >= target) {
                return nums.length-i;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        int[] nums = new int[]{12,28,83,4,25,26,25,2,25,25,25,12};
        int target = 213;
        System.out.println(minSubArrayLen(target, nums));
    }
}
