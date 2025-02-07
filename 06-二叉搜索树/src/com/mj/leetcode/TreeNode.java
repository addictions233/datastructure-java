package com.mj.leetcode;

/**
 * @description: leetcode上的二叉树节点
 * @author: wanjunjie
 * @date: 2025/02/07
 */
public class TreeNode {
    int val;

    TreeNode left;

    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
