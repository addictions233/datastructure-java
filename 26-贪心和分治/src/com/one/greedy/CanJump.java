package com.one.greedy;

import java.util.Arrays;

/**
 * @description: 55. 跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false
 * @author: wanjunjie
 * @date: 2024/12/06
 */
public class CanJump {

    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            if (max >= nums.length) {
                return true;
            }
            max = Math.max(max, i + nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        canJump(nums);
    }

    public int inventoryManagement(int[] stock) {
        Arrays.sort(stock);
        return stock[stock.length >> 1];
    }
}
