package com.one.string.kmp;

/**
 * @author one
 * @description TODO
 * @date 2025-1-5
 */
public class KMP01 {

    public static int indexOf(String text, String pattern) {
        char[] textChars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int textLen = textChars.length;
        int patternLen = patternChars.length;

        int[] next = next(patternChars);
        int pi = 0;
        int ti = 0;
        while(pi < patternLen && ti - pi < textLen - patternLen) {
            if (pi < 0 || textChars[ti] == patternChars[pi]) {
                ti++;
                pi++;  // 当0号位不匹配时, pi的值会是-1, 所以需要判断pi < 0
            } else {
                // 如果出现不匹配, 则ti回退到ti - pi + 1的位置, pi回退到0的位置
                pi = next[pi];
            }
        }
        return pi == patternLen ? ti - pi : -1;
    }

    private static int[] next(char[] patternChars) {
        int[] next = new int[patternChars.length];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < patternChars.length - 1) {
            if (j == -1 || patternChars[i] == patternChars[j]) {
                i++;
            }
        }
        return next;
    }
}
