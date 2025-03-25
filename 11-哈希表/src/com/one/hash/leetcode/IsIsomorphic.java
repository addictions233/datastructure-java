package com.one.hash.leetcode;

import java.util.HashMap;

/**
 * @description: 205. 同构字符串
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，
 * 相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * @author: wanjunjie
 * @date: 2025/01/24
 */
public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        for (int i = 0; i < source.length; i++) {
            int value = target[i] - source[i];
            if (map.getOrDefault(source[i], value) != value) {
                return false;
            }
            if (map2.getOrDefault(target[i], value) != value) {
                return false;
            }
            map.put(source[i], value);
            map2.put(target[i], value);
        }
        return true;
    }
}
