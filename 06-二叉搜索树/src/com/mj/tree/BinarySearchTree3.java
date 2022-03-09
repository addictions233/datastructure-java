package com.mj.tree;

import com.mj.bean.Comparable;
import com.mj.bean.Comparator;
import com.mj.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: BinarySearchTree3
 * @Description: 第三次写二叉搜索树
 * @Author: one
 * @Date: 2021/06/17
 */
public class BinarySearchTree3<E> implements BinaryTreeInfo {


    /**
     * 内部类: Node
     * 二叉搜索树内部用Node节点存储元素,和链表类似
     * 如果内部类不使用外部类的非静态成员,就将该内部类设置为静态的
     * 静态内部类的优点是方便使用, 非静态内部类的优点是可以使用外部类的非静态成员
     *
     * @param <E>
     */
    private static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        /**
         * 构造函数,新添加一个节点只需要指定存储元素,并指定父节点
         *
         * @param element 节点存储的元素
         * @param parent  父节点
         */
        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

    /**
     * 由于二叉搜索树中传入的元素必须具有可比较性,为了更灵活的比较元素,可以让元素类型不实现Comparable接口,
     * 但是在构造二叉搜索树对象时必须传入一个比较器Comparator对象
     */
    private Comparator<E> comparator;

    /**
     * 存储的节点个数
     */
    private int size;

    /**
     * 二叉搜索树的根节点
     */
    private Node<E> root;

    /**
     * 空参构造
     */
    public  BinarySearchTree3() {
        super();
    }

    /**
     * 有参构造: 传入比较器对象, 这样二叉搜索树可以对存储的元素类型设置灵活的比较方式
     * @param comparator 比较器对象
     */
    public BinarySearchTree3(Comparator<E> comparator) {
        this.comparator = comparator;
    }


    private int size() {
        return this.size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void clear() {

    }

    /**
     * 向二叉搜索树中添加元素
     *
     * @param element 元素
     */
    public void add(E element) {
        // 二叉搜索树中存储的元素都是可以比较的,所以不能为null
        notNullCheck(element);
        // 如果根节点为空的情况
        if (null == root) {
            root = new Node<>(element,null);
            size++;
            return;
        }
        //使用迭代的方式查找新加入的元素存储的节点位置
        // 要保存的元素和它要比较的节点,最开始肯定是root根节点比较
        Node<E> node = root;
        // 比较的结果值
        int compare = 0;
        // 要保存元素的父节点
        Node<E> parent = root;
        while(node != null) {
            parent = node;
            compare = this.compare(element,node.element);
            if ( compare > 0) {
                // 迭代的过程,变量不断朝着目标演变
                node = node.right;
            } else if ( compare < 0) {
                node = node.left;
            } else {
                //如果传入的元素和原本节点中存储的元素相等,那么就用新传入的元素对象替换旧的元素对象
                node.element = element;
                return;
            }
        }
        // 创建要保存的节点对象
        Node<E> newNode = new Node<>(element,parent);
        // 让其父节点指向新创建的节点
        if (compare > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    public boolean contains(E element) {
        return false;
    }

    /**
     * 前序遍历: 先访问父节点, 然后是左子节点, 再是右子节点
     */
    public void preorderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        // 前序遍历肯定从根节点root开始
        preorderTraversal(root,visitor);
    }

    /**
     * 采用递归的方式对二叉树进行前序遍历: 1,方法带形参 2,方法有出口 3,方法内部调用方法本身且形参朝着出口的方向变化
     * @param node 节点
     */
    private void  preorderTraversal(Node<E> node,Visitor<E> visitor) {
        //递归方法的出口:
        if (node == null || visitor.stop) {
            return;
        }
        // 前序遍历先遍历父节点
        visitor.stop = visitor.visit(node.element);
        // 再遍历左子节点
        preorderTraversal(node.left,visitor);
        // 再遍历右子节点
        preorderTraversal(node.right,visitor);
    }

    /**
     * 中序遍历: 先访问左子节点,然后访问父节点,最后是右子节点
     * 注意: 中序遍历出的结果,要么全是升序排列, 要么全是降序排列
     */
    public void inorderTraversal(Visitor<E> visitor) {
        if(visitor == null) {
            return;
        }
        inorderTraversal(root,visitor);
    }

    /**
     * 递归的方式实现二叉树的中序遍历
     * @param node 节点
     */
    private void inorderTraversal(Node<E> node,Visitor<E> visitor) {
       if (node == null || visitor.stop) {
           return;
       }
       // 先遍历左子树
       inorderTraversal(node.left,visitor);
       if (visitor.stop) {
           return;
       }
       // 再遍历父节点
        visitor.stop = visitor.visit(node.element);
        // 最后遍历右子树
        inorderTraversal(node.right,visitor);
    }

    /**
     * 后续遍历: 先是左子节点,然后是右子节点,最后是父节点
     */
    public void postorderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            return;
        }
        postorderTraversal(root,visitor);
    }

    /**
     * 采用递归的方式实现后续遍历
     * @param node 节点
     */
    private void postorderTraversal(Node<E> node,Visitor<E> visitor) {
        if ( node == null || visitor.stop) {
            return;
        }
        // 先遍历左子树
        postorderTraversal(node.left,visitor);
        // 然后遍历右子树
        postorderTraversal(node.right,visitor);
        if (visitor.stop) {
            return;
        }
        // 最后遍历父节点
        visitor.stop = visitor.visit(node.element);

    }

    /**
     * 层序遍历: 二叉树从左到右,从上到下依次遍历
     */
    public void levelOrderTraversal(Visitor<E> visitor) {
        levelOrderTraversal(root,visitor);
    }

    /**
     * 采用迭代的方式对二叉树进行层序遍历
     * @param node 节点
     */
    private void levelOrderTraversal(Node<E> node,Visitor<E> visitor) {
        if(node == null || visitor == null) {
            return;
        }
        // 使用队列来存储要被遍历的节点
        Queue<Node<E>> queue = new LinkedList<>();
        // 入队列
        queue.offer(node);
        // 出队列
        while (queue.size() > 0) {
            Node<E> poll = queue.poll();
            if (visitor.visit(poll.element)) {
                // 如果遍历的visit()方法返回true,表示不再继续遍历
                return;
            }
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }

    /**
     * 二叉搜索树存储的元素必须是可以比较的,所以不能存储空元素
     *
     * @param element 要存储的元素
     */
    private void notNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element can not be null");
        }
    }

    /**
     * 访问器接口: 对二叉搜素树遍历的节点元素进行处理
     */
    public static abstract class Visitor<E> {
        /**
         * 遍历结束的标识
         */
         private boolean stop;

        /**
         * 对节点元素进行处理的方法
         * @param e 节点元素
         * @return boolean 如果返回true表示遍历结束,不再往下遍历
         */
        abstract boolean visit(E e);
    }

    /**
     * 二叉搜索树存储的元素必须是具有可比较性的,所以传入的元素类型要么实现了Comparable接口,要么传入Comparator比较器对象
     * 二叉树中存储的元素必须实现Comparable接口,可以使用泛型来约束元素类型
     * 而Comparator比较器则可以让元素类型灵活的实现比较方式
     * @param element 要新增的元素
     * @param target 已存储节点的元素
     * @return int
     */
    private int compare(E element, E target) {
        // 如果创建二叉搜索树时对成员变量比较器对象进行了初始化,优先使用比较器对象对传入的元素进行比较
        if (comparator != null) {
            return comparator.compare(element,target);
        }
        // 如果没有对比较器对象进行初始化,就必须让传入的元素类型实现Comparable接口
        Comparable<E> comparable = (Comparable<E>)element;
        return comparable.compareTo(target);
    }

    /**
     * 查询给定节点的前驱节点, 前驱节点: 中序遍历(从小到大排序)时,该节点的前一个节点
     * @param node
     * @return
     */
    private Node<E> predecessor(Node<E> node) {
        // 如果该节点有左子树,那么该节点的前驱节点是它的左子树中值最大的节点
        if (node.left != null) {
            Node<E> predecessor = node.left;
            while(predecessor.right != null) {
                predecessor = predecessor.right;
            }
            return predecessor;
        }
        // 如果该节点的左子树为空,那么该节点的前驱节点是它的父级节点中第一个向左的父级节点
        while(node.parent != null && node.parent.left == node) {
            node = node.parent;
        }
        // node.parent == null 或者 node.parent.right == node
        return node.parent;
    }

    /**
     * 查询一个节点的后继节点, 后继节点: 中序遍历二叉树时,该节点的后一个节点
     * @param node
     * @return
     */
    private Node<E> successor(Node<E> node) {
        // 如果存在右子树,就查找右子树中最小的节点
        if (node.right != null) {
            Node<E> successor = node.right;
            while(successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }
        // 如果存在父节点,就查找第一个是父节点右子节点的父节点
        while(node.parent != null && node.parent.right == node) {
            node = node.parent;
        }
        // node.parent == null 或者 node.parent.left = node
        return node.parent;
    }

    /**
     * 提供删除元素的接口
     * @param element 元素
     */
    public void remove(E element) {
        remove(node(element));
    }

    private void remove(Node<E> node) {

    }

    /**
     * 获取二叉树中元素element对应的节点node
     * @param element 元素
     * @return Node<E>
     */
    private Node<E> node(E element) {
        notNullCheck(element`);
        Node<E> node = root;
        while(node != null) {
            int compare = compare(node.element, element);
            if (compare > 0) {
                node = node.left;
            } else if (compare < 0) {
                node = node.right;
            } else {
                break;
            }
        }
        return node;
    }

    /**
     * 实现BinaryTreeInfo接口是为了在控制台打印二叉搜索树
     * @return 根节点
     */
    @Override
    public Object root() {
        return this.root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>)node).element;
    }
}


