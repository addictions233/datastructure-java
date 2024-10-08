package com.one.recursion;

/**
 * @author one
 * @description 递归百分之百可以转回为非递归
 * @date 2022-9-8
 */
public class RecursionConvert {
    public static void main(String[] args) {
        log(4);
    }

    /**
     * 写一个简单的递归函数
     *
     * @param n 递归参数
     */
    private static void log(int n) {
        // 递归函数的边界
        if (n < 1) {
            return;
        }
        log(n - 1);
        // 原问题和子问题的关系
        int v = n + 10;
        // 递归函数的作用
        System.out.println(v);
    }

    /**
     * 手动使用stack栈模拟递归函数入栈的调用过程
     *
     * @param n 递归参数
     */
    private static void stackFrame (int n) {}
}
