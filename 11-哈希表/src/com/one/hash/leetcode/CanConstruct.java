package com.one.hash.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 383. 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次
 * @author: wanjunjie
 * @date: 2025/01/24
 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> target = new HashMap<>();
        HashMap<Character, Integer> source = new HashMap<>();
        for (char ch : ransomNote.toCharArray()) {
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }
        for (char ch : magazine.toCharArray()) {
            source.put(ch, source.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            Character key = entry.getKey();
            if (source.getOrDefault(key,0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
