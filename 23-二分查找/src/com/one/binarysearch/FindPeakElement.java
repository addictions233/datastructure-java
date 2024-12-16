package com.one.binarysearch;

/**
 * @description: 162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * @author: wanjunjie
 * @date: 2024/12/16
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        return binarySearch(nums, 0, nums.length -1);
    }

    public int binarySearch(int[] nums, int start, int end) {
        if (start >= end) {
            return start;
        }
        int mid = (start + end) >> 1;
        if (mid == 0 ) {
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            } else {
                return mid +1;
            }
        }
        if (mid == nums.length -1){
            return mid;
        }
        if (nums[mid] > nums[mid + 1]) {
            if (nums[mid] > nums[mid -1]) {
                return mid;
            } else {
                return binarySearch(nums,start, mid -1);
            }
        } else {
            return binarySearch(nums, mid +1, end);
        }
    }
}
