package com.one.string.kmp;

/**
 * @author one
 * @description kmp算法: 1. 求解Next数组  2. 使用Next数组进行移位
 * @date 2025-1-5
 */
public class KMP01 {

    public static void main(String[] args) {
        String text = "abcdefghijklmnodefdefpqrstuvwxyz";
        String pattern = "defdef";
        System.out.println(indexOf(text, pattern));
    }

    public static int indexOf(String text, String pattern) {
        char[] textChars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int textLen = textChars.length;
        int patternLen = patternChars.length;

        int[] next = next(pattern);
        int pi = 0;
        int ti = 0;
        while(pi < patternLen && ti - pi < textLen - patternLen) {
            if (pi < 0 || textChars[ti] == patternChars[pi]) {
                ti++;
                pi++;  // 当0号位不匹配时, pi的值会是-1, 所以需要判断pi < 0, pi++还是0
            } else {
                // 如果出现不匹配, pi回退到next[pi]位置
                // ti不变, 就相当于ti不回退了, 已经比较过的ti就不再重复比较了, 效率更高
                pi = next[pi];
            }
        }
        return pi == patternLen ? ti - pi : -1;
    }

    private static int[] next(String pattern) {
        int length = pattern.length();
        int[] next = new int[length];
        int i = 0;
        int n = next[i] = - 1;
        int imax = length - 1;
        while (i < imax) {
            if (n < 0 || pattern.charAt(i) == pattern.charAt(n)) {
                next[++i] = ++n;
            } else {
                n = next[n];
            }
        }
        return next;
    }
}
