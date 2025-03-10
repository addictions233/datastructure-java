package com.one.leetcode;

/**
 * @description: 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * @author: wanjunjie
 * @date: 2025/03/03
 */
public class NumTrees {
    public int numTrees(int n) {
        // 定义状态含义 G[n] 表示n个节点组成的二叉搜索树的种数
        int[] G = new int[n + 1];
        // 定义状态初始化值
        G[0] = 1;
        G[1] = 1;
        // 定义状态转移方法
        // G[n] = G[0]*G[n-1] + G[1]*G[n-2] + ... + G[n-1]*G[0]
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
