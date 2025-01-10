package com.one.string.kmp.leetcode;

/**
 * @description: 796. 旋转字符串
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 * @author: wanjunjie
 * @date: 2025/01/09
 */
public class RotateString {

    /**
     * 将问题转换为使用goal匹配text中的位置
     */
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String text = s + s;
        char[] textArr = text.toCharArray();
        char[] goalArr = goal.toCharArray();
        int ti = 0, gi = 0;
        int[] next = next(goal);
        int tmax = textArr.length - goalArr.length;
        while (gi < goalArr.length && ti - gi <= tmax) {
            if (gi < 0 || goalArr[gi] == textArr[ti]) {
                ti++;
                gi++;
            } else {
                gi = next[gi];
            }
        }
        return gi == goalArr.length;
    }

    /**
     * @param goal 对goal求解next数组
     */
    private int[] next(String goal) {
        int[] next = new int[goal.length()];
        int i = 0;
        int n = next[i] = -1;
        int imax = goal.length() - 1;
        while(i < imax) {
            if (n < 0 || goal.charAt(i) == goal.charAt(n)) {
                next[++i] = ++n;
            } else {
                n = next[n];
            }
        }
        return next;
    }
}
