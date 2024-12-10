package com.one.binarysearch;

/**
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题
 * @author: wanjunjie
 * @date: 2024/12/10
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1,-1};
        }
        return binarySearch(nums, 0, nums.length, target);
    }

    /**
     * 这里利用了分治的思想
     */
    public int[] binarySearch(int[] nums, int start, int end, int target) {
        if (end - start < 1) {
            return new int[]{-1,-1};
        }
        int middle = (start + end) >> 1;
        if (nums[middle] > target) {
            return binarySearch(nums, start, middle, target);
        }

        if (nums[middle] < target) {
            return binarySearch(nums, middle + 1, end, target);
        }
        int[] result = new int[]{middle, middle};
        for (int i = middle + 1; i < end; i++) {
            if (nums[i] == target) {
                result[1] = i;
            }
        }

        for (int i = middle - 1; i >= start; i--) {
            if (nums[i] == target) {
                result[0] = i;
            }
        }
        return result;
    }
}
