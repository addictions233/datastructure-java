package com.one.string.leetcode;

import org.junit.Test;

/**
 * @description: 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @author: wanjunjie
 * @date: 2025/01/24
 */
public class LongestCommonPrefix {

    /**
     * 广度优先搜索(BFS)
     */
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        outLoop:
        while (true) {
            int value = -1;
            for (String str : strs) {
                if (str.length() <= index) {
                    break outLoop;
                }
                if (value == -1) {
                    value = str.charAt(index);
                }
                if (value != str.charAt(index)) {
                    break outLoop;
                }
            }
            index++;
        }
        return strs[0].substring(0, index);
    }


    /**
     * 深度优先搜索(DFS)
     */
    public String longestCommonPrefix2(String[] strs) {
        String source = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (source.isEmpty()) {
                return source;
            }
            source = findCommonPrefix(source, strs[i]);
        }
        return source;
    }

    private String findCommonPrefix(String s1, String s2) {
        int index = 0;
        while (index < s1.length() && index < s2.length()) {
            if (s1.charAt(index) != s2.charAt(index)) {
                break;
            }
            index++;
        }
        return s1.substring(0, index);
    }

    @Test
    public void test() {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
