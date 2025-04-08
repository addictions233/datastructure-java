package com.mj.leetcode;

/**
 * @description: 530. 二叉搜索树的最小绝对差
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * @author: wanjunjie
 * @date: 2025/04/08
 */
public class GetMinimumDifference {

    private int ans = Integer.MAX_VALUE;

    private int prev = Integer.MIN_VALUE / 2;


    public int getMinimumDifference(TreeNode root) {
        // 二叉搜索树的中序遍历
        middleTraverser(root);
        return ans;
    }


    public void middleTraverser(TreeNode node) {
        if (node == null) {
            return;
        }
        middleTraverser(node.left);
        ans = Math.min(ans, node.val - prev);
        prev = node.val;
        middleTraverser(node.right);
    }

}
