package com.one.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 395. 至少有 K 个重复字符的最长子串
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * 如果不存在这样的子字符串，则返回 0。
 * @author: wanjunjie
 * @date: 2025/03/20
 */
public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> times = new HashMap<>(chars.length);
        for (char aChar : chars) {
            times.put(aChar, times.getOrDefault(aChar, 0) + 1);
        }
        int len = 0;
        int left = 0;
        for (int right = 0; right < chars.length; right++) {
            if (times.get(chars[right]) >= k) {
                len = Math.max(len, right - left + 1);
            } else {
                left = right + 1;
            }

        }
        return len;
    }
}
