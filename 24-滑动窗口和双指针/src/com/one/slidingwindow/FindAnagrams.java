package com.one.slidingwindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * @author: wanjunjie
 * @date: 2025/03/10
 */
public class FindAnagrams {
    /**
     * 第一种方法：使用定长窗口
     */
    public List<Integer> findAnagrams(String s, String p) {
        int[] cns = new int[26];
        int[] cnp = new int[26];

        // 使用定长的滑动窗口
        char[] arr1 = p.toCharArray();
        for (char c : arr1) {
            cnp[c - 'a']++;
        }
        List<Integer> result = new LinkedList<>();
        char[] arr2 = s.toCharArray();
        for (int right = 0; right < arr2.length; right++) {
            // 1. 初始化窗口
            if (right < arr1.length -1) {
                cns[arr2[right] - 'a']++;
                continue;
            }
            // 2.元素进入窗口
            cns[arr2[right] - 'a']++;
            // 3.判断结果是否满足条件
            int left = right - arr1.length + 1;
            if (Arrays.equals(cns, cnp)) {
                result.add(left);
            }
            // 4.左侧元素出窗口
            cns[arr2[left] - 'a']--;
        }
        return result;
    }

    /**
     * 第二种方法：使用不定长窗口
     */
    public List<Integer> findAnagrams2(String s, String p) {
        int[] cnp = new int[26];
        char[] arr1 = p.toCharArray();
        for (char c : arr1) {
            cnp[c - 'a']++;
        }
        char[] arr2 = s.toCharArray();
        List<Integer> result = new LinkedList<>();
        // 1.定义滑动窗口的左边界left和右边界right
        int left = 0;
        for (int right = 0; right < arr2.length; right++) {
            // 2.右边界的元素进入窗口
            int index = arr2[right] - 'a';
            cnp[index]--;
            // 3.判断是否符合条件
            while (cnp[index] < 0) {
                // 4,不满足条件, left左移，左侧元素出窗口
                cnp[arr2[left] - 'a']++;
                left++;
            }
            if (right - left + 1 == arr1.length) {
                result.add(left);
            }
        }
        return result;
    }
}
