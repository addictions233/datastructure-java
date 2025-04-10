package com.mj.leetcode;

/**
 * @description: 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @author: wanjunjie
 * @date: 2025/04/10
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isValid(TreeNode node, long maxValue, long minValue) {
        if (node == null) {
            return true;
        }
        return (node.val < maxValue && node.val > minValue) && isValid(node.left, node.val, minValue)
                && isValid(node.right, maxValue, node.val);
    }
}
