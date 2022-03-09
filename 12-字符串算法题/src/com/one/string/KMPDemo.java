package com.one.string;

import java.util.Arrays;

/**
 * @ClassName: KMPDemo
 * @Description: KMP算法的实现: KMP算法的重点在于如何计算next数组
 * @Author: one
 * @Date: 2021/07/29
 */
public class KMPDemo {
    public static void main(String[] args) {
        String str  = "abcdabcmk";
        char[] ch = str.toCharArray();
        int length = ch.length;
        int[] next = new int[length];
        // next数组的起始值都是-1
        next[0]= -1;
        // i表示模式串的字符下标
        int i = 0;
        // j表示所求字符的前一个字符的next数组值
        int j = -1;
        while(i < length-1) {
            if ( j == -1 || ch[i] == ch[j]) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        System.out.println(Arrays.toString(next));

        String target = "abcabcdabcmkfl";
        char[] chars = target.toCharArray();
        int n = 0;
        int p = 0;
        while(n < target.length() && p < length) {
            if ( p == -1 || chars[n] == ch[p]) {
                n++;
                p++;
            } else {
                p = next[p];
            }
        }
        if ( p == length) {
            System.out.println( n -p);
        } else {
            System.out.println( -1);
        }
    }
}
