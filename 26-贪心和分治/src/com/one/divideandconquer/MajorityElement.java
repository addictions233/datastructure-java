package com.one.divideandconquer;

import java.util.Arrays;

/**
 * @description: 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @author: wanjunjie
 * @date: 2024/12/06
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int x = Integer.MIN_VALUE; int count = 0;
        for (int num : nums) {
            if (count == 0) {
                x = num;
                count ++;
            } else {
                if (x == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return x;
    }

    public int[] inventoryManagement(int[] stock, int cnt) {
        Arrays.sort(stock);
        return Arrays.copyOfRange(stock, 0, cnt + 1);
    }
}
