package com.mj.tree;

import com.mj.bean.Comparable;
import com.mj.bean.Comparator;
import com.mj.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @ClassName: BinarySearchTree3
 * @Description: 实现二叉树搜索树
 * @Author: one
 * @Date: 2022/03/15
 */
public class BinarySearchTree3<E> implements BinaryTreeInfo {
    /**
     * 比较器: 二叉搜索树的存储元素必须是可比较的
     * 1, 第一种传入自定义的比较器comparator
     * 2, 让元素实现comparable接口
     */
    private Comparator<E> comparator;

    public BinarySearchTree3(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public BinarySearchTree3() {
        this(null);
    }

    /**
     * 节点对象,用来封装元素以及节点关系,静态内部类也是顶级类
     *
     * @param <E> 元素泛型
     */
    private static class Node<E> {
        E element;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

    /**
     * 二叉搜索树的根节点
     */
    private Node<E> root;

    /**
     * 存储元素个数
     */
    private int size;

    /**
     * 二叉树存储元素个数
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 清空二叉树
     */
    public void clear() {
        this.root = null;
        this.size = 0;
    }

    /**
     * 添加元素
     *
     * @param element 元素
     */
    public void add(E element) {
        // 非空校验
        checkNotNull(element);
        if (root == null) { // 添加根元素
            root = new Node<>(element, null);
            this.size++;
            return;
        }
        int compareResult = 0;
        // 要比较的节点
        Node<E> node = root;
        // 要比较的节点的父节点,记录新添加节点的父节点
        Node<E> parent = root;
        while (node != null) {
            compareResult = compare(node.element, element);
            if (compareResult > 0) { // 取左子节点继续比较
                // 记录父节点
                parent = node;
                node = node.left;
            } else if (compareResult < 0) { // 取右子节点继续比较
                parent = node;
                node = node.right;
            } else { // 相等的情况
                node.element = element; // 用新值替换旧值
                return;
            }
        }
        // 添加新的节点,让新添加节点的parent指向父节点
        Node<E> addNode = new Node<>(element, parent);
        if (compareResult > 0) { // 在父节点的左子节点添加新的元素节点
            parent.left = addNode;
        } else { // 在父节点的左子节点添加新的元素节点
            parent.right = addNode;
        }
        size++;
    }

    /**
     * 比较两个元素的大小
     *
     * @param element1 元素1
     * @param element2 元素2
     * @return int
     */
    private int compare(E element1, E element2) {
        if (comparator != null) {
            // 传入了比较器,优先使用比较器
            return comparator.compare(element1, element2);
        }
        // 如果没有传入比较器,那么元素一定要实现Comparable接口
        return ((Comparable<E>) element1).compareTo(element2);
    }


    /**
     * 对二叉树进行前序遍历, 先遍历父节点
     */
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node<E> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.element);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /**
     * 对二叉树进行中序遍历, 先遍历左子节点,再遍历父节点
     */
    public void inorderTraversal() {
        inorderTraversal(root);

    }

    private void inorderTraversal(Node<E> root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.element);
        inorderTraversal(root.right);
    }

    /**
     * 对二叉树进行后序遍历, 先遍历左子节点,再遍历右子节点, 最后遍历父节点
     */
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node<E> root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.element);
    }

    /**
     * 对二叉树进行层序遍历
     */
    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        // 当父节点出队列,其子节点进队列
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            System.out.println(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 删除元素
     *
     * @param element 元素
     */
    public void remove(E element) {

    }

    /**
     * 找一个节点的前驱节点:中序遍历该节点的前一个节点
     *
     * @param node 节点对象
     * @return 前驱节点
     */
    private Node<E> predecessor(Node<E> node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) { // 如果该节点的左子树不为空
            // 找到左子树中值最大的节点
            node = node.left;
            while (node.right != null) {
                node = node.right;
            }
            return node;
        } else {
            // 找该节点的父节点中第一个右子树中包含该节点的父节点
            while(node.parent != null && node.parent.left == node) {
                node = node.parent;
            }
            // 跳出while循环有两种情况: 1, 父节点为null  2,父节点的右子节点为该节点
            return node.parent;
        }

    }

    private Node<E> successor(Node<E> node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) { // 右子树不为空的情况
            // 找出右子树中节点最小的值
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else { // 找出该节点父节点中第一个左子树包含该节点的父节点
            while (node.parent != null && node.parent.right == node) {
                node = node.parent;
            }
            return node.parent;
        }
    }

    /**
     * 判断是否包含元素
     *
     * @param element 元素
     * @return boolean
     */
    public boolean contains(E element) {
        return false;
    }

    /**
     * 非空校验
     *
     * @param element 元素
     */
    private void checkNotNull(E element) {
        if (element == null) {
            throw new IllegalArgumentException("二叉搜索树中存储的元素不能为空");
        }
    }

    /**
     * who is the root node
     */
    @Override
    public Object root() {
        return this.root;
    }

    /**
     * how to get the left child of the node
     *
     * @param node
     */
    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    /**
     * how to get the right child of the node
     *
     * @param node
     */
    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    /**
     * how to print the node
     *
     * @param node
     */
    @Override
    public Object string(Object node) {
        return ((Node<E>) node).element;
    }
}
