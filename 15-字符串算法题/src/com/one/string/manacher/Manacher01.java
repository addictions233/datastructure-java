package com.one.string.manacher;

/**
 * @description: Manacher算法（马拉车算法）是一种高效的算法，用于在线性时间复杂度内找出字符串中最长的回文子串。‌
 * 该算法通过在原字符串的每个字符之间插入一个特殊字符（如#），并将首尾也添加特殊字符，以确保回文中心可以落在任意位置。
 * 这样处理后，无论是奇数长度的回文串还是偶数长度的回文串，都可以统一处理。‌
 * @author: wanjunjie
 * @date: 2025/01/07
 */
public class Manacher01 {

    public static void main(String[] args) {
        String target = "afdfjdlhld342";
        System.out.println(manacher(target));
    }


    public static int manacher(String s) {
        StringBuilder str = new StringBuilder();
        str.append('!');
        for (int i = 0; i < s.length(); i++) {
            str.append('#');
            str.append(s.charAt(i));
        }
        str.append("#+");
        int[] p = new int[str.length()];
        //r：所有的回文子串中最大的右边界
        //c：对应的中心点
        int c = 0, r = 0, max = -1;
        for (int i = 1; i < str.length() - 1; i++) {
            p[i] = i < r ? Math.min(r - i, p[2 * c - i]) : 1;
            while (str.charAt(p[i] + i) == str.charAt(i - p[i])) {
                p[i]++;
            }
            if (p[i] + i > r) {
                r = p[i] + i;
                c = i;
            }
            //真是的长度是p[i]-1，因为我们添加了字符，不是原来的字符串
            max = Math.max(p[i] - 1, max);
        }
        return max;
    }

}
