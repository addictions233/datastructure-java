package com.one.hash.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * @author: wanjunjie
 * @date: 2025/03/24
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> st = new HashSet<>();
        // 把 nums 转成哈希集合
        for (int num : nums) {
            st.add(num);
        }
        // 遍历哈希集合
        for (int x : st) {
            if (st.contains(x - 1)) {
                continue;
            }
            // x 是序列的起点
            int y = x + 1;
            // 不断查找下一个数是否在哈希集合中
            while (st.contains(y)) {
                y++;
            }
            // 循环结束后，y-1 是最后一个在哈希集合中的数
            // 从 x 到 y-1 一共 y-x 个数
            ans = Math.max(ans, y - x);
        }
        return ans;
    }

}
