package com.one.greedy;

/**
 * @description: 134. 加油站
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * @author: wanjunjie
 * @date: 2024/12/16
 */
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int result = 0;
        int minSum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {
                result = i + 1;
                minSum = sum;
            }
        }
        return sum < 0 ? -1 : result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, -3, 1, 5, -10, 6};
    }
}
