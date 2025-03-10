package com.one.leetcode;

import java.util.List;

/**
 * @description: 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * @author: wanjunjie
 * @date: 2025/03/03
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 定义状态含义, dp[i] 表示s中前i个字符是否可以被wordDict中的单词拼接出来
        boolean[] dp = new boolean[s.length()+1];
        // 定义状态初始化值
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
