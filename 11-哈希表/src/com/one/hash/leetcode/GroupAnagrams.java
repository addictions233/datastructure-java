package com.one.hash.leetcode;

import javax.lang.model.element.VariableElement;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * @author: wanjunjie
 * @date: 2025/03/10
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            resultMap.computeIfAbsent(new String(chars), key -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(resultMap.values());
    }
}
