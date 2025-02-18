package com.one.hash.leetcode;

/**
 * @description: 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
 * @author: wanjunjie
 * @date: 2025/02/18
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        // 判断两个字符串的长度是否相等, 如果不相等, 直接返回false
        if (s.length() != t.length()) {
            return false;
        }
        // 使用数组记录每个字符的次数
        int[] array = new int[23];
        char[] chars1 = s.toCharArray();
        for (char c : chars1) {
            int index = c - 97;
            array[index] = array[index] + 1;
        }
        char[] chars2 = t.toCharArray();
        for (char ch : chars2) {
            int index = ch - 97;
            array[index] = array[index] -1;
        }
        for (int i : array) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf('a'));
    }
}
