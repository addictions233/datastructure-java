package com.mj.leetcode;

/**
 * @description: 230. 二叉搜索树中第 K 小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 * @author: wanjunjie
 * @date: 2025/04/09
 */
public class KthSmallest {

    public int ans  = 0;

    public int k = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        middleTraverse(root);
        return ans;
    }

    public void middleTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        middleTraverse(node.left);
        if (--k == 0) {
            ans = node.val;
            return;
        }
        middleTraverse(node.right);
    }
}
