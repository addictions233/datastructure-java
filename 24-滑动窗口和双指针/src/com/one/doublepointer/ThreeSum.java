package com.one.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * @author: wanjunjie
 * @date: 2025/02/10
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        // 对数组进行排序
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] + nums[i] > 0) {
                    end--;
                } else if (nums[start] + nums[end] + nums[i] < 0) {
                    start++;
                } else {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    do {
                        start++;
                    } while (nums[start] == nums[start-1] && start < end);
                    do {
                        end--;
                    } while (nums[end] == nums[end+1] && end > start);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0};
        threeSum(nums);
    }
}
