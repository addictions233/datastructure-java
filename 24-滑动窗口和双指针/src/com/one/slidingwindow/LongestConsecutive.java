package com.one.slidingwindow;

import java.util.Arrays;
import java.util.EnumSet;

/**
 * @description: 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * @author: wanjunjie
 * @date: 2025/03/24
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = nums[0];
        int result = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] == nums[right - 1]) {
                continue;
            } else if (nums[right] == nums[right - 1] + 1) {
                // 窗口满足条件,更新结果
                result = Math.max(result, nums[right]- left + 1);
            } else {
                // 窗口不满足条件, left右移, 直到窗口满足条件
                left = nums[right];
            }
        }
        return result;
    }
}
