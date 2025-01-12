package com.one.string.kmp.leetcode;

/**
 * @description: 2108. 找出数组中的第一个回文字符串
 * 给你一个字符串数组 words ，找出并返回数组中的 第一个回文字符串 。如果不存在满足要求的字符串，返回一个 空字符串 "" 。
 * 回文字符串 的定义为：如果一个字符串正着读和反着读一样，那么该字符串就是一个 回文字符串 。
 * @author: wanjunjie
 * @date: 2025/01/09
 */
public class FirstPalindrome {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    /**
     * 判断一个字符串是否是回文串
     */
    private boolean isPalindrome(String target) {
        int first = 0;
        int last = target.length() - 1;
        while(first < last) {
            if (target.charAt(first) != target.charAt(last)) {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }
}
