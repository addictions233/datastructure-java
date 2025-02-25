package com.one.leetcode;

/**
 * @description: 268. 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * @author: wanjunjie
 * @date: 2025/02/25
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {

        int[] target = new int[nums.length+1];
        for (int num : nums) {
            target[num] = 1;
        }
        for (int index = 0; index < target.length; index++) {
            if (target[index] == 0) {
                return index;
            }
        }
        return 0;
    }
}
