package com.one.string.kmp.leetcode;

import org.junit.Test;

import java.lang.annotation.Target;

/**
 * @description: 28. 找出字符串中第一个匹配项的下标
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 * @author: wanjunjie
 * @date: 2025/01/07
 */
public class StrMatch {

    public int strStr(String haystack, String needle) {
        char[] textChars = haystack.toCharArray();
        char[] patternChars = needle.toCharArray();
        int ti = 0, pi = 0;
        int[] next = next(patternChars);
        int tmax = textChars.length - patternChars.length;
        while (pi < patternChars.length && ti - pi < tmax) {
            if (pi < 0 || patternChars[pi] == textChars[ti]) {
                pi++;
                ti++;
            } else {
                pi = next[pi];
            }
        }
        return pi == patternChars.length ? ti - pi : -1;
    }

    private int[] next(char[] patternChars) {
        int[] next = new int[patternChars.length];
        next[0] = -1;
        if (patternChars.length == 1) {
            return next;
        }
        next[1] = 0;
        for (int i = 2; i < patternChars.length; i++) {
            if (patternChars[i - 1] == patternChars[next[i -1]]) {
                next[i] = next[i -1] + 1;
            } else {
                next[i] = 0;
            }
        }
        return next;
    }

    @Test
    public void test() {
        int i = strStr("aabaaabaaac", "aabaaac");
        System.out.println(i);
    }

}
