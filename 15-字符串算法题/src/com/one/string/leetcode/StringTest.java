package com.one.string.leetcode;

import java.util.Scanner;

/**
 * @description: 给定M个字符（a-z），从中取任意字符（每个字符只能用一次）拼接成长度为N的字符串，相同的字符不能相邻。
 * 计算给定的字符列表能拼接出多少种满足条件的字符串，输入非法或者无法拼接出满足条件的字符串则输出0；
 * @author: wanjunjie
 * @date: 2025/03/17
 */
public class StringTest {

    public static char[] target;
    public static Integer n;
    public static int[] setArray;
    public static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] split = line.split(" ");
        target = split[0].toCharArray();
        n = Integer.parseInt(split[1]);
        setArray = new int[target.length];
        place(0, '#');
        System.out.println(result);
    }

    public static void place(int time, char last) {
        if (time >= n) {
            result++;
            return;
        }
        for (int i = 0; i < target.length; i++) {
            if (setArray[i] != 1 && target[i] != last) {
                setArray[i] = 1;
                place(time+1, target[i]);
            }
            setArray[i] = 0;
        }
    }
}
