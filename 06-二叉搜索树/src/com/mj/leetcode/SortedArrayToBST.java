package com.mj.leetcode;

/**
 * @description: 108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵平衡二叉搜索树。
 * @author: wanjunjie
 * @date: 2025/02/08
 */
public class SortedArrayToBST {

    /**
     * 采用分治的思想: 找出中间的父节点, 然后组装左子树和右子树
     * @param nums 排序数组
     * @return 二叉搜索树的根节点
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return getTreeNode(nums, 0, nums.length);
    }

    public TreeNode getTreeNode(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int middle = (start + end) >> 1;
        return new TreeNode(nums[middle], getTreeNode(nums,start, middle), getTreeNode(nums, middle+1,end));
    }
}
