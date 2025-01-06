package com.one.string;

/**
 * @author one
 * @description 查找模式串pattern在文本串text中位置的暴力算法
 * @date 2025-1-6
 */
public class BruteForce02 {


    public static int indexOf(String text, String pattern) {
        char[] textChars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();

        int tLength = textChars.length;
        int pLength = patternChars.length;

        for (int ti = 0; ti <= tLength - pLength; ti++) {
            int pi = 0;
            for (; pi < pLength; pi++) {
                if (textChars[pi + ti] != patternChars[pi]) {
                    break;
                }
            }
            if (pi == pLength) {
                return ti;
            }
        }
        return -1;
    }
}
