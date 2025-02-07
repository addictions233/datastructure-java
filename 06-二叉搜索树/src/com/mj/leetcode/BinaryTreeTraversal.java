package com.mj.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description: 二叉树的前序遍历, 中序遍历, 后续遍历, 层序遍历 (递归和非递归实现)
 * @author: wanjunjie
 * @date: 2025/02/07
 */
public class BinaryTreeTraversal {

    /**
     * 前序遍历: 先父节点, 再左子树, 再右子树
     * 递归实现
     * @param root 二叉树的根节点
     */
    public void preOrder(TreeNode root){
        if (root == null) {
            return;
        }
        // 先父节点
        System.out.println(root.val);
        // 再左子树
        preOrder(root.left);
        // 再右子树
        preOrder(root.right);
    }

    /**
     * 前序遍历: 迭代实现 (借用第三方数据结构 Stack栈)
     * @param root 二叉树的根节点
     */
    public void preOrder2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            // 由于栈结构是先进后出, 所以先压右子树, 再压左子树
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历: 先遍历左子树, 再父节点, 再右子树
     * @param root 二叉树的根节点
     */
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 先左子树
        inorder(root.left);
        // 再父节点
        System.out.println(root.val);
        // 再右子树
        inorder(root.right);
    }

    /**
     * 中序遍历: 迭代实现 (借用第三方数据结构 Stack栈)
     * @param root 二叉树的根节点
     */
    public void inorder2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 先遍历左子节点,再遍历父节点
            node = stack.pop();
            System.out.println(node.val);
            // 最后遍历右子节点
            node = node.right;
        }
    }

    /**
     * 后续遍历: 先遍历左子树, 后遍历右子树, 最后遍历父节点
     * @param root 二叉树的根节点
     */
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 先遍历左子树
        postOrder(root.left);
        // 后遍历右子树
        postOrder(root.right);
        // 最后是父节点
        System.out.println(root.val);
    }

    /**
     * 后续遍历: 迭代实现, 借用第三方数据结构(栈)
     * @param root 二叉树的根节点
     */
    public void postOrder2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode prev = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 弹栈, 但是该节点不能立马遍历
            // 只有该节点的右子树为空, 或者右子节点为上一个遍历的节点才能遍历该节点
            node = stack.pop();
            if (node.right == null || node.right == prev) {
                // 遍历该节点
                System.out.println(node.val);
                // 将该节点设置为上一个遍历的节点
                prev = node;
                // 将node设置为null ,是为了继续弹栈
                node = null;
            } else {
                // 说明之前弹栈的节点有右子树, 且右子树没有被遍历, 该弹栈的节点需要继续压栈
                stack.push(node);
                // 遍历右子树
                node = node.right;
            }
        }
    }

    /**
     * 层序遍历: 逐层遍历二叉树 (借助第三方数据结构 队列Queue FIFO先进先出)
     * @param root 二叉树的根节点
     */
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            // 队列是FIFO, 先进先出, 所以先进左子树, 后进右子树, 和栈结构是反着的
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
}
