package com.one.string.manacher;

/**
 * @description: TODO
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
