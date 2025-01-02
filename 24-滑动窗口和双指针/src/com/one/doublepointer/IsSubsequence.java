package com.one.doublepointer;

/**
 * @description: 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * @author: wanjunjie
 * @date: 2024/12/27
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        char[] target = s.toCharArray();
        char[] source = t.toCharArray();
        int index1 = 0;
        int index2 = 0;
        while(index1 < target.length && index2 < source.length) {
            if (target[index1] == source[index2]) {
                index1++;
                index2++;
            } else {
                index2++;
            }
        }
        return index1 == target.length;
    }
}
