package com.one.recursion;

/**
 * @author one
 * @description 练习2: 楼梯有n阶台阶, 上楼可以一步上1阶, 也可以一步上2阶, 走完n阶台阶共有多少中不同的走法
 *                  1, 确认递归函数的作用  递归函数有相同的处理参数和处理过程
 *                  2, 确认原函数和子函数的关系  参数参数朝着递归边界移动
 *                  3, 确认递归函数的边界
 * @date 2022-9-1
 */
public class JumpStair {
    public static void main(String[] args) {
        System.out.println(jumpStairs(3));
    }

    /**
     * 递归写法
     */
    public static int jumpStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return jumpStairs(n-2) + jumpStairs(n-1);
        }

    }

    /**
     * 迭代写法
     */
    public static int jumpStairs1(int n) {
        int numb1 = 1;
        int numb2 = 2;
        int result = numb1;
        for (int i = 3; i <= n; i++) {
            result = numb1 + numb2;
            numb1 = numb2;
        }
        return result;
    }
}
