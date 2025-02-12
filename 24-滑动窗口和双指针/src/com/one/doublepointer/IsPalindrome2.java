package com.one.doublepointer;

/**
 * @description: 680. 验证回文串 II
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 * @author: wanjunjie
 * @date: 2025/02/10
 */
public class IsPalindrome2 {
    public boolean validPalindrome(String s) {
        // 边界处理
        if (s.length() <= 2) {
            return true;
        }
        char[] array = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (array[start] == array[end]) {
                start++;
                end--;
            } else {
                return isPalindrome(s.substring(start, end)) || isPalindrome(s.substring(start + 1, end + 1));
            }
        }
        return true;
    }

    private boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }
        char[] array = str.toCharArray();
        int start = 0;
        int end = array.length -1;
        while (start < end) {
            if (array[start] != array[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
