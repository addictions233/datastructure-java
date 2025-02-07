package com.one.doublepointer;

import org.junit.Test;

/**
 * @description: 80. 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @author: wanjunjie
 * @date: 2025/01/23
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int start = 0;
        int end = 1;
        int times = 1;
        while (end < nums.length) {
            if (nums[start] == nums[end]) {
                times++;
                if (times > 2) {
                    end++;
                    continue;
                }
            } else {
                times = 1;
            }
            nums[start+1] = nums[end];
            start++;
            end++;
        }
        return start;
    }

    @Test
    public void test() {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }
}
