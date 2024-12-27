package com.one.doublepointer;

import org.junit.Test;

/**
 * @description: 125. 验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * @author: wanjunjie
 * @date: 2024/12/27
 */
public class IsPalindrome {

    @Test
    public void test() {
        isPalindrome("0P");
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length -1;
        while(start < end) {
            if (!isMatch(chars[start])) {
                start++;
                continue;
            }

            if (!isMatch(chars[end])) {
                end--;
                continue;
            }
            if (Character.toLowerCase(chars[start]) != Character.toLowerCase(chars[end])) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    private boolean isMatch(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
}
