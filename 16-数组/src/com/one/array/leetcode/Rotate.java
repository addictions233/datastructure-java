package com.one.array.leetcode;

import java.awt.*;
import java.awt.font.NumericShaper;
import java.util.Arrays;

/**
 * @description: 189. 轮转数组  给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * @author: wanjunjie
 * @date: 2025/03/25
 */
public class Rotate {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] arr = Arrays.copyOfRange(nums, 0, k);
        for (int i = 0; i < k; i++) {
            swap(nums,i, k, arr[i]);
        }
    }

    public static void swap(int[] nums, int i, int k, int source) {
        if (i > nums.length) {
            return;
        }
        int target = (i + k) % nums.length;
        int temp = nums[target];
        nums[target] = source;
        swap(nums, i + k, k, temp);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums, 3);
    }
}
