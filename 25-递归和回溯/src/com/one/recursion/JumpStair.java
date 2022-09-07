package com.one.recursion;

/**
 * @author one
 * @description 练习2: 楼梯有n阶台阶, 上楼可以一步上1阶, 也可以一步上2阶, 走完n阶台阶共有多少中不同的走法
 * @date 2022-9-1
 */
public class JumpStair {
    public static void main(String[] args) {

    }

    public int jumpStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return jumpStairs(n-2) + jumpStairs(n-1);
        }

    }
}
