package com.one.string.kmp.leetcode;

/**
 * @description: 3407. 子字符串匹配模式
 * 给你一个字符串 s 和一个模式字符串 p ，其中 p 恰好 包含 一个 '*' 符号。
 * p 中的 '*' 符号可以被替换为零个或多个字符组成的任意字符序列。
 * 如果 p 可以变成 s 的子字符串，那么返回 true ，否则返回 false 。
 * @author: wanjunjie
 * @date: 2025/01/09
 */
public class HasMatch {
    public boolean hasMatch(String s, String p) {
        String[] split = p.split("\\*");
        if (split.length == 0) {
            return true;
        }
        char[] textArr = s.toCharArray();
        int ti = 0;
        String pattern1 = split[0];
        if (!pattern1.isEmpty()) {
            char[] p1Arr = pattern1.toCharArray();
            int pi = 0;
            int[] next1 = next(p1Arr);
            int tmax = textArr.length - p1Arr.length;
            while (pi < p1Arr.length && ti - pi <= tmax) {
                if (pi < 0 || p1Arr[pi] == textArr[ti]) {
                    pi++;
                    ti++;
                } else {
                    pi = next1[pi];
                }
            }
            if (pi != p1Arr.length) {
                return false;
            }
        }

        if (split.length == 2) {
            String pattern2 = split[1];
            char[] p2Arr = pattern2.toCharArray();
            int pi = 0;
            int[] next2 = next(p2Arr);
            int tmax = textArr.length - p2Arr.length;
            while (pi < p2Arr.length && ti - pi <= tmax) {
                if (pi < 0 || p2Arr[pi] == textArr[ti]) {
                    pi++;
                    ti++;
                } else {
                    pi = next2[pi];
                }
            }
            return pi == p2Arr.length;
        }
        return true;

    }

    private int[] next(char[] pattern) {
        int[] next = new int[pattern.length];
        int i = 0;
        int n = next[i] = -1;
        int imax = next.length - 1;
        while (i < imax) {
            if (n < 0 || pattern[i] == pattern[n]) {
                next[++i] = ++n;
            } else {
                n = next[n];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "*j";
        String[] split = str.split("\\*");
        System.out.println(split);
    }
}
