package com.one.tools;

/**
 * @ClassName: Integers
 * @Description: Integer数组工具类
 * @Author: one
 * @Date: 2022/05/23
 */
public class Integers {
    /**
     * 生成指定数量，指定范围的随机数
     *
     * @param amount 生成的数组长度
     * @param min 最小值
     * @param max 最大值
     * @return 数组
     */
    public static Integer[] random(int amount, int min, int max) {
        if (amount <= 0 || min > max) {
            return null;
        }
        Integer[] array = new Integer[amount];
        int num = max - min + 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*num) + min;
        }
        return array;
    }

    public static void println(Integer[] array) {
        if (array == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length-1) {
                sb.append("_");
            }
        }
        System.out.println(sb.toString());
    }
}
