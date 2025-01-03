package com.one.slidingwindow;

import org.junit.Test;

/**
 * @description: 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * @author: wanjunjie
 * @date: 2025/01/03
 */
public class MinSubArrayLen {

    /**
     * 子数组: 数组中连续的 非空元素序列
     */
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            // 进入窗口
            sum += nums[i];
            // 初始化滑动窗口
            if (sum < target) {
               continue;
            } else {
                // 出窗口
                while(sum >= target) {
                    sum -= nums[start];
                    start++;
                }
                // 计算结果
                result = Math.min(i - start + 2, result);
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    @Test
    public void test() {
//        int[] nums = new int[]{12,28,83,4,25,26,25,2,25,25,25,12};
        int[] nums = new int[]{2,3,1,2,4,3};
//        int target = 213;
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }
}
