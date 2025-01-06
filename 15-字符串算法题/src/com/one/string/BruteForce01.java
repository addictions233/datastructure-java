package com.one.string;

/**
 * @author one
 * @description 查找模式串pattern在文本串text中位置的暴力算法
 * @date 2025-1-5
 */
public class BruteForce01 {

    public static void main(String[] args) {
        String text = "abcdefghijklmnopqrstuvwxyz";
        String pattern = "def";
        System.out.println(indexOf(text, pattern));
    }

    /**
     * 暴力解法: 在文本串中逐个开始匹配模式串, 直到找到匹配的位置, 或者文本串遍历完毕
     */
    public static int indexOf(String text, String pattern) {
        char[] textChars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int textLen = textChars.length;
        int patternLen = patternChars.length;
        int pi = 0;
        int ti = 0;
        while(pi < patternLen && ti < textLen) {
            if (textChars[ti] == patternChars[pi]) {
                ti++;
                pi++;
            } else {
                // 如果出现不匹配, 则ti回退到ti - pi + 1的位置, pi回退到0的位置
                ti = ti - pi + 1;
                pi = 0;
            }
        }
        return pi == patternLen ? ti - pi : -1;
    }
}
