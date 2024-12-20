package com.one.slidingwindow;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: 187. 重复的DNA序列
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 * @author: wanjunjie
 * @date: 2024/12/20
 */
public class FindRepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        // 使用哈希表保存所有的字符串的数量
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String key = s.substring(i, i + 10);
            countMap.compute(key, (k, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    if (val == 1) {
                        result.add(key);
                    }
                    return val + 1;
                }
            });
        }
        return result;
    }
}
