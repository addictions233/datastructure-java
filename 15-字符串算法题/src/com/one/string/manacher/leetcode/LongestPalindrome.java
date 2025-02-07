package com.one.string.manacher.leetcode;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

/**
 * @description: 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * @author: wanjunjie
 * @date: 2025/01/22
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        // 定义状态转移方程
        // dp[i][j]表示从第i个字符到第j个字符组成的子串是否为回文串
        boolean[][] dp = new boolean[s.length()][s.length()];

        // 设置状态初始化值
        int length = s.length();
        // 对于长度为1的字符肯定是回文串
        for (int i = 0; i < length; i++) {
            // 一个字符肯定是回文串,
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 状态转移方程: dp[i][j] = dp[i+1][j-1] && charArray[i] == charArray[j]
        // 如果一个字符串是回文串, 那么去掉前后两个字符后, 仍然是回文串, 且前后两个字符相同
        // 第一层循环: 判断长度为2的子串是否为回文串, 直到判断长度为length的子串是否为回文串
        int start = 0;
        int maxLength = 1;
        for (int l = 2; l <= length; l++) {
            // 从第一个字符开始 index = 0
            for (int i = 0; i < length; i++) {
                int j = i + l - 1;
                if (j > length - 1) {
                    // 如果 j 越界, 则退出循环
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    // 如果前后两个字符不相同, 则不是回文串
                    dp[i][j] = false;
                } else {
                    // 如果前后两个字符相同, 则判断去掉前后两个字符后, 仍然是回文串
                    if (j - i < 3)  {
                        //如果去掉前后两个字符后, 只剩下一个字符或者不剩下字符, 则是回文串
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    @Test
    public void test() {
        String s = "ab";
        System.out.println(longestPalindrome(s));
    }
}
