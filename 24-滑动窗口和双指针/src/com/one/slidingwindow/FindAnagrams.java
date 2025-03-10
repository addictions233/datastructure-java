package com.one.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * @author: wanjunjie
 * @date: 2025/03/10
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        char[] targetChar = p.toCharArray();
        Arrays.sort(targetChar);
        int length = targetChar.length;
        String target = new String(targetChar);
        char[] window = new char[length];
        for (int i = 0; i < chars.length; i++) {
            // 1. 初始化窗口
            if (i < length - 1) {
                window[i] = chars[i];
            }
            // 2.进入窗口
            int index = i % length;
            window[index] = chars[i];
            // 3. 计算结果
            char[] newChars = Arrays.copyOf(window, length);
            Arrays.sort(newChars);
            String windowStr = new String(newChars);
            if (windowStr.equals(target)) {
                result.add(i - length + 1);
            }
        }
        return result;
    }
}
