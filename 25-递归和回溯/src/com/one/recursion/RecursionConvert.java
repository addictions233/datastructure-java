package com.one.recursion;

import java.util.Stack;

/**
 * @author one
 * @description 递归百分之百可以转回为非递归
 * @date 2022-9-8
 */
public class RecursionConvert {
    public static void main(String[] args) {
        log(4);
        System.out.println("-------------------");
        stackFrame(4);

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
    private static void stackFrame (int n) {
        // 自己维护一个栈的数据结构, 保存每次调用的参数和局部变量
        Stack<Frame> stack = new Stack<>();
        while (n > 0) {
            stack.push(new Frame(n, n + 10));
            n--;
        }
        while (!stack.isEmpty()) {
            Frame frame = stack.pop();
            System.out.println(frame.v);
        }
    }

    static class Frame {
        int n;
        int v;
        Frame(int n, int v) {
            this.n = n;
            this.v = v;
        }
    }
}
