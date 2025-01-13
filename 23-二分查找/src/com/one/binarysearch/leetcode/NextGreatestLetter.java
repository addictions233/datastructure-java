package com.one.binarysearch.leetcode;

/**
 * @description: 744. 寻找比目标字母大的最小字母
 * 给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target。letters 里至少有两个不同的字符。
 * 返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符
 * @author: wanjunjie
 * @date: 2025/01/13
 */
public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];
    }
}
