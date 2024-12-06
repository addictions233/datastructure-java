package com.one.slidingwindow;

/**
 * @description: 1456. 定长子串中元音的最大数目
 * 给你字符串 s 和整数 k 。
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * 英文中的 元音字母 为（a, e, i, o, u）。
 * @author: wanjunjie
 * @date: 2024/12/06
 */
public class MaxVowels {

    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();

        int max = 0;
        int vowels = 0;
        for (int i = 0; i < chars.length; i++) {
            // 初始化窗口
            if (i < k - 1) {
                if (isVowel(chars[i])) {
                    vowels++;
                }
                continue;
            }
            // 进入窗口
            if (isVowel(chars[i])) {
                vowels++;
            }
            // 更新结果
            max = Math.max(max, vowels);
            // 离开窗口
            char leave = chars[i - k + 1];
            if (isVowel(leave)) {
                vowels--;
            }
        }
        return max;
    }

    boolean isVowel(char target) {
        return target == 'a' || target == 'e' || target == 'i' || target == 'o' || target == 'u';
    }
}
