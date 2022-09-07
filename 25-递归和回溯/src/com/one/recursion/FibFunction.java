package com.one.recursion;

/**
 * @author one
 * @description 使用递归计算斐波那契数列
 * @date 2022-9-7
 */
public class FibFunction {
    public static void main(String[] args) {
        System.out.println(fib0(20));
        System.out.println(fib1(20));
        System.out.println(fib2(20));
        System.out.println(fib3(20));
    }

    /**
     * 斐波那契数列的递归实现的空间复杂度是 O(n), 时间复杂度达到了O(2^n), 存在大量的重复计算
     *
     * @param n 斐波那契数列的第n个位置
     * @return 计算第n个位置的值
     */
    public static int fib0(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib0(n - 1) + fib0(n - 2);
    }

    /**
     * 使用数组存储已经计算出的fib(n), 降低递归计算的时间复杂度
     *      空间复杂度  O(n) + O(n)  还是 O(n)
     *      时间复杂度 每个fib(n)只计算一次, 所以时间复杂度为 O(n)
     *
     * @param n 斐波那契数列的第n个位置
     * @return 计算第n个位置的值
     */
    public static int fib1(int n) {
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        return fib1(n,array);
    }

    private static int fib1(int n, int[] array) {
        if (array[n] != 0) {
            return array[n];
        }
        return fib1(n - 1, array) + fib1(n - 2, array);
    }


    /**
     * 所有的递归和迭代都能互相转换
     *      使用迭代进行实现: 空间复杂度: O(n), 时间复杂度: O(n)
     * @param n 斐波那契数列的第n个位置
     * @return 计算第n个位置的值
     */
    public static int fib2(int n) {
        if (n <= 2) {
         return 1;
        }
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i-1] + array[i -2];
        }
        return array[n];
    }

    /**
     * 每次只使用到了数组中的前两个数字, 可以考虑使用滚动数组
     *     使用滚动数组的空间复杂度降低为O(1)
     * @param n 斐波那契数列的第n个位置
     * @return 计算第n个位置的值
     */
    public static int fib3(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i & 1] = array[(i - 1) & 1] + array[(i - 2) & 1];
        }
        return array[n & 2];
    }
}
