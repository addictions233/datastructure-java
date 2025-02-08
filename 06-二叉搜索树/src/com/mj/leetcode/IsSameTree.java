package com.mj.leetcode;

/**
 * @description: 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @author: wanjunjie
 * @date: 2025/02/07
 */
public class IsSameTree {

    /**
     * 只有父节点, 左子树, 右子树全都相等, 这个两个二叉树才是相同二叉树
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p != null && q == null) || (p == null && q != null)) {
            return false;
        }
        if (p == null) {
            return true;
        }
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
}
