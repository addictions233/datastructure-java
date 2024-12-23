package com.one.doublepointer;

import java.util.EmptyStackException;

/**
 * @description: 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * @author: wanjunjie
 * @date: 2024/12/23
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(fast <nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }
}
