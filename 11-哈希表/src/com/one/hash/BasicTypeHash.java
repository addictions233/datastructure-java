package com.one.hash;

/**
 * @ClassName: Test
 * @Description: 计算 int float long double四种基本数据类型的hash值
 * @Author: one
 * @Date: 2021/03/09
 */
public class BasicTypeHash {
    public static void main(String[] args) {
        int i = 100;
        System.out.println(Integer.hashCode(i));
    }
}
