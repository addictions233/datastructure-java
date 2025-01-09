package com.one.string.kmp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 面试题 17.17. 多次搜索
 * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，
 * 对big进行搜索。输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 * @author: wanjunjie
 * @date: 2025/01/09
 */
public class MultiSearch {

    /**
     * 使用kmp多次匹配
     */
    public int[][] multiSearch(String big, String[] smalls) {
        int[][] result = new int[smalls.length][];
        char[] textArr = big.toCharArray();
        for (int i = 0; i < smalls.length; i++) {
            char[] patternArr = smalls[i].toCharArray();
            if (patternArr.length == 0) {
                result[i] = new int[0];
                continue;
            }
            int[] next = next(patternArr);
            int ti = 0;
            int pi = 0;
            int tmax = textArr.length - patternArr.length;
            List<Integer> indexList = new LinkedList<>();
            while (ti - pi <= tmax) {
                if (pi < 0 || textArr[ti] == patternArr[pi]) {
                    ti++;
                    pi++;
                } else {
                    pi = next[pi];
                }
                if (pi == patternArr.length) {
                    indexList.add(ti - pi);
                    ti = ti - pi + 1;
                    pi = 0;
                }
            }
            result[i] = indexList.stream().mapToInt(Integer::intValue).toArray();
        }
        return result;
    }

    private int[] next(char[] pattern) {
        int[] next = new int[pattern.length];
        int i = 0;
        int n = next[i] = -1;
        int imax = next.length - 1;
        while(i < imax) {
            if (n < 0 || pattern[i] == pattern[n]) {
                next[++i] = ++n;
            } else {
                n = next[n];
            }
        }
        return next;
    }
}
