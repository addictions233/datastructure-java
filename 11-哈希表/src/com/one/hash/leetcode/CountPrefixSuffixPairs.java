package com.one.hash.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 3042. 统计前后缀下标对 I
 * 给你一个下标从 0 开始的字符串数组 words 。
 * 定义一个 布尔 函数 isPrefixAndSuffix ，它接受两个字符串参数 str1 和 str2 ：
 * 当 str1 同时是 str2 的前缀（prefix）和后缀（suffix）时，isPrefixAndSuffix(str1, str2) 返回 true，否则返回 false。
 * 例如，isPrefixAndSuffix("aba", "ababa") 返回 true，因为 "aba" 既是 "ababa" 的前缀，也是 "ababa" 的后缀，但是 isPrefixAndSuffix("abc", "abcd") 返回 false。
 * 以整数形式，返回满足 i < j 且 isPrefixAndSuffix(words[i], words[j]) 为 true 的下标对 (i, j) 的 数量 。
 * @author: wanjunjie
 * @date: 2025/03/04
 */
public class CountPrefixSuffixPairs {

    public int countPrefixSuffixPairs(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (String word : words) {

        }
        return 0;
    }
}

