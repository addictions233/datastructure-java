package com.mj.leetcode;

import com.mj.stack.Stack;

import java.util.Arrays;
import java.util.Queue;

/**
 * @description: 2390. 从字符串中移除星号
 * 给你一个包含若干星号 * 的字符串 s 。
 * 在一步操作中，你可以：
 * 选中 s 中的一个星号。
 * 移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
 * 返回移除 所有 星号之后的字符串。
 * 注意：
 * 生成的输入保证总是可以执行题面中描述的操作。
 * 可以证明结果字符串是唯一的。
 * @author: wanjunjie
 * @date: 2025/01/06
 */
public class RemoveStars {

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if ('*' == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Character pop = stack.pop();
            sb.append(pop);
        }
        return sb.reverse().toString();
    }
}
