package com.mj.leetcode;

import java.util.Stack;

/**
 * @description: 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * @author: wanjunjie
 * @date: 2025/01/06
 */
public class IsValid {


    /**
     * 借助栈的数据结构来实现: 左括号入栈, 右括号出栈, 最后栈为空, 则有效
     * 一个有括号抵消一个左括号
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (isLeft(c)) {
                stack.push(c);
            } else {
                // 如果栈为空, 返回false
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (!isMatch(pop, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeft(Character c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isMatch(Character left, Character right) {
        return (left == '(' && right == ')') || (left == '{' && right == '}') || (left == '[' && right == ']');
    }
}
