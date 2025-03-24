package com.one.test;

/**
 * @ClassName: Main
 * @Description: 测试类
 * @Author: one
 * @Date: 2022/05/05
 */
public class Main {
    public static void main(String[] args) {
        String str = "92988";

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char max = chars[i];
            int index = -1;
            for (int j = i+1; j < chars.length; j++) {
                if (chars[j] >= max) {
                    max = chars[j];
                    index = j;
                }
            }
            if (index != -1) {
                chars[index] = chars[i];
                chars[i] = max;
                System.out.println(new String(chars));
            }
        }
    }
}
