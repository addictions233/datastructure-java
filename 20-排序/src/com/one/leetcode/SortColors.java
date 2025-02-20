package com.one.leetcode;

/**
 * @description: 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * @author: wanjunjie
 * @date: 2025/02/19
 */
public class SortColors {
    public void sortColors(int[] nums) {
        // 使用选择排序
        for (int end = nums.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int start = 1; start <= end; start++) {
                if (nums[maxIndex] < nums[start]) {
                    maxIndex = start;
                }
            }
            // 找到最大值,交互到end位置
            int temp = nums[end];
            nums[end] = nums[maxIndex];
            nums[maxIndex] = temp;
        }
    }
}
