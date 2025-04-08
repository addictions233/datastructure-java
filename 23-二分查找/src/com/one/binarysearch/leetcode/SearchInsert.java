package com.one.binarysearch.leetcode;

/**
 * @description: 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * @author: wanjunjie
 * @date: 2025/04/08
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        return findIndex(0, nums.length, target, nums);
    }

    public int findIndex(int start, int end, int target, int[] nums) {
        if (end - start <= 1) {
            if (target > nums[start]) {
                return start + 1;
            } else {
                return start;
            }
        }
        int middle = (start + end) >> 1;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] > target) {
            return findIndex(start, middle, target, nums);
        } else {
            return findIndex(middle, end, target, nums);
        }
    }
}
